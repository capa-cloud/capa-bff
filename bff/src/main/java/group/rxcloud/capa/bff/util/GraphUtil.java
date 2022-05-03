package group.rxcloud.capa.bff.util;


import group.rxcloud.capa.bff.exception.IllegalInvocationRequestException;
import group.rxcloud.capa.bff.domain.HJsonInvocationRequest;

import java.util.*;

/**
 * @author wangjun
 * @date 2021/10/25
 */
public class GraphUtil {

    /**
     * node集合
     */
    private final List<HJsonInvocationRequest> serviceNodes = new ArrayList<>();

    /**
     * 有向图的邻接矩阵
     */
    private final int[][] adjacencyMatrix;

    public GraphUtil(List<HJsonInvocationRequest> services) {
        if (services == null) {
            throw new NullPointerException("services is null!");
        }
        Set<String> nickNameList = new HashSet<>();
        Map<String, HJsonInvocationRequest> serviceResponse = new HashMap<>();
        for (HJsonInvocationRequest service : services) {

            serviceNodes.add(service);
            if (service.getResponseDataFormat() != null && !service.getResponseDataFormat().isEmpty()) {

                for (String path : service.getResponseDataFormat().keySet()) {

                    String pathValue = service.getResponseDataFormat().get(path);
                    String nickName;
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

    public boolean find() throws IllegalInvocationRequestException {
        // 从出发节点到当前节点的轨迹
        List<Integer> trace = new ArrayList<>();
        //返回值
        List<String> result = new ArrayList<>();
        if (adjacencyMatrix.length > 0) {
            findCycle(0, trace, result);
        }
        if (result.size() == 0) {
            result.add("no cycle!");
            return false;
        }
        throw new IllegalInvocationRequestException(result.get(0));
    }

    private void findCycle(int v, List<Integer> trace, List<String> reslut) {
        int j;
        //添加闭环信息
        if ((j = trace.indexOf(v)) != -1) {
            StringBuilder sb = new StringBuilder();
            HJsonInvocationRequest startNode = serviceNodes.get(trace.get(j));
            while (j < trace.size()) {
                sb.append(serviceNodes.get(trace.get(j)).getAppId()).append("-");
                j++;
            }
            reslut.add("cycle:" + sb + startNode.getAppId());
            return;
        }
        trace.add(v);
        for (int i = 0; i < serviceNodes.size(); i++) {
            if (adjacencyMatrix[v][i] == 1) {
                findCycle(i, trace, reslut);
            }
        }
        trace.remove(trace.size() - 1);
    }
}
