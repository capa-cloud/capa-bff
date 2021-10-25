package group.rxcloud.capa.bff.core.graph;

import group.rxcloud.capa.bff.domain.InvocationRequest;

/**
 * @author wangjun
 * @date 2021/10/25
 */
public class InvocationEdge<T> {
    /**
     * 边的起点
     */
    private InvocationRequest<T> src;
    /**
     * 边的终点
     */
    private InvocationRequest<T> dest;

    public InvocationRequest<T> getSrc() {
        return src;
    }

    public void setSrc(InvocationRequest<T> src) {
        this.src = src;
    }

    public InvocationRequest<T> getDest() {
        return dest;
    }

    public void setDest(InvocationRequest<T> dest) {
        this.dest = dest;
    }
}
