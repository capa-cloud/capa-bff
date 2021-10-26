package group.rxcloud.capa.bff.hjson.util;


import group.rxcloud.capa.bff.domain.DependOnFieldInfo;
import group.rxcloud.capa.bff.domain.InvocationRequest;
import group.rxcloud.capa.bff.exception.IllegalInvocationRequestException;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;

import java.util.*;

/**
 * @author wangjun
 * @date 2021/10/25
 */
public class GraphUtil {
    public static void main(String[] args) {
        List<HJsonInvocationRequest> list = new ArrayList<>();
        HJsonInvocationRequest service01 = new HJsonInvocationRequest();
        service01.setAppId("test01");
        Map<String, Object> map01 = new HashMap<>();
        map01.put("a.name",null);

        Map<String, Object> map02 = new HashMap<>();
        map02.put("b.name",null);
        service01.setRequiredParams(map01);
        Map<String, String> responseMap01 = new HashMap<>();
        responseMap01.put("name","a.name");
        service01.setResponseDataFormat(responseMap01);
        list.add(service01);

        GraphUtil g = new GraphUtil(list);
        g.find();
    }

    /**
     * node集合
     */
    private List<HJsonInvocationRequest> serviceNodes = new ArrayList<>();


    /**
     * 有向图的邻接矩阵
     */
    private int[][] adjacencyMatrix;

    private Map<String, HJsonInvocationRequest> serviceResponse;


    public GraphUtil(List<HJsonInvocationRequest> services) {
        if (services == null) {
            throw new NullPointerException("services is null!");
        }
        Set<String> nickNameList = new HashSet<>();
        serviceResponse = new HashMap<>();
        for (int x = 0; x < services.size(); x++) {

            HJsonInvocationRequest service = services.get(x);
            serviceNodes.add(service);
            if (service.getResponseDataFormat() != null && !service.getResponseDataFormat().isEmpty()) {

                for (String path : service.getResponseDataFormat().keySet()) {

                    String pathValue = service.getResponseDataFormat().get(path);
                    String nickName = "";
                    if (pathValue.contains("#{")) {
                        nickName = pathValue.substring(pathValue.lastIndexOf("}") + 1);
                    } else {
                        nickName = pathValue;
                    }
                    if (nickNameList.contains(nickName)) {
                        throw new IllegalInvocationRequestException("nickName repeat!");
                    }
                    nickNameList.add(nickName);
                    serviceResponse.put(nickName, service);

                }

            }

        }

        adjacencyMatrix = new int[serviceNodes.size()][serviceNodes.size()];

        // add dependency
        for (int x = 0; x < serviceNodes.size(); x++) {
            HJsonInvocationRequest service = serviceNodes.get(x);
            if (service.getRequiredParams() != null && !service.getRequiredParams().isEmpty()) {
                for (String nickName : service.getRequiredParams().keySet()) {



                    HJsonInvocationRequest serviceDepend = serviceResponse.get(nickName);
                    if (serviceDepend == null) {
                        throw new IllegalInvocationRequestException("[" + service.getAppId() + "] " + nickName + "  no service offer");
                    }
                    int startIndex = serviceNodes.indexOf(service);
                    int endIndex = serviceNodes.indexOf(serviceDepend);
                    adjacencyMatrix[startIndex][endIndex] = 1;
                }
            }
        }
    }

    public  boolean  find() {
        // 从出发节点到当前节点的轨迹
        List<Integer> trace =new ArrayList<Integer>();
        //返回值
        List<String> reslut = new ArrayList<>();
        if(adjacencyMatrix.length>0) {
            findCycle(0, trace,reslut);
        }
        if(reslut.size()==0) {
            reslut.add("no cycle!");
            return false;
        }
        throw new IllegalInvocationRequestException(reslut.get(0));
    }

    private void findCycle(int v, List<Integer> trace, List<String> reslut) {
        int j;
        //添加闭环信息
        if((j=trace.indexOf(v))!=-1) {
            StringBuffer sb = new StringBuffer();
            HJsonInvocationRequest startNode = serviceNodes.get(trace.get(j));
            while(j<trace.size()) {
                sb.append(serviceNodes.get(trace.get(j)).getAppId()+"-");
                j++;
            }
            reslut.add("cycle:"+sb.toString()+startNode.getAppId());
            return;
        }
        trace.add(v);
        for(int i=0;i<serviceNodes.size();i++){
            if(adjacencyMatrix[v][i]==1) {
                findCycle(i,trace,reslut);
            }
        }
        trace.remove(trace.size()-1);
    }


}