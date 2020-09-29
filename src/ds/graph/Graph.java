package ds.graph;

import java.util.List;

/**
 * @author Achan
 * @date 2020/9/29
 */
public interface Graph<V> {

    /**
     * 获取节点数量
     * @return 节点数量
     */
    int getNodeSize();

    /**
     * 获取图的所有节点
     * @return 图的节点
     */
    List<V> getVertices();

    /**
     * 获取指定下标的节点
     * @param index 指定下标
     * @return 获取到的节点
     */
    V getVertex(int index);

    /**
     * 获取指定节点的下标
     * @param v 指定节点
     * @return 该节点的下标，如果不存在返回-1
     */
    int indexOf(V v);

    /**
     * 获取所有指定下标节点的邻居节点
     * @param index 指定下标
     * @return 所有邻居节点的集合
     */
    List<Integer> getNeighbors(int index);

    /**
     * 获取指定下标节点的度
     * @param index 下标
     * @return 所在节点的度
     */
    int getDegree(int index);

    /**
     * 清除图
     */
    void clear();

    /**
     * 添加v到图中，如果存在则添加失败
     * @param v 需要添加的节点
     * @return 是否成功
     */
    boolean addVertex(V v);

    /**
     * 添加从u到v的边
     * @param u 起点下标
     * @param v 终点下标
     * @throws IllegalArgumentException u或v无效
     * @return 是否添加成功
     */
    boolean addEdge(int u, int v) throws IllegalArgumentException;
}
