package group.rxcloud.capa.bff.core.graph;


import group.rxcloud.capa.bff.domain.DependOnFieldInfo;
import group.rxcloud.capa.bff.exception.IllegalInvocationRequestException;

import java.util.List;

/**
 * @author wangjun
 * @date 2021/10/25
 */
public class GraphUtil<T> {

    public void queryHasIllegalInvocation(List<DependOnFieldInfo<T>> fieldInfoList) throws IllegalInvocationRequestException {

    }

    /**
     * 添加一个端点
     * @param v string
     * @return 新增端点的编号，-1表示插入失败
     */
    private int add(String v) {
        return 0;
    }

    /**
     * 添加一个边
     * @param e 边
     */
    public void add(InvocationEdge e) {

    }
}
