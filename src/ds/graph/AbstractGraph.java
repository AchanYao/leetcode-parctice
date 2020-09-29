package ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/9/29
 */
public abstract class AbstractGraph<V> implements Graph<V> {

    protected List<V> vertices = new ArrayList<>();
    protected List<List<Edge>> neighbors = new ArrayList<>();

    @Override
    public int getNodeSize() {
        return vertices.size();
    }

    @Override
    public List<V> getVertices() {
        return vertices;
    }

    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    public int indexOf(V v) {
        return vertices.indexOf(v);
    }

    @Override
    public List<Integer> getNeighbors(int index) {
        List<Integer> result = new ArrayList<>();
        for (Edge e : neighbors.get(index)) {
            result.add(e.v);
        }
        return result;
    }

    @Override
    public int getDegree(int index) {
        return neighbors.get(index).size();
    }

    @Override
    public void clear() {
        vertices.clear();
        neighbors.clear();
    }

    @Override
    public boolean addVertex(V v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
            neighbors.add(new ArrayList<>());
            return true;
        }
        return false;
    }

    protected boolean addEdge(Edge e) {
        if (e.u < 0 || e.u > getNodeSize() - 1) {
            throw new IllegalArgumentException("没有该下标：" + e.u);
        }
        if (e.v < 0 || e.v > getNodeSize() - 1) {
            throw new IllegalArgumentException("没有该下标：" + e.v);
        }
        if (!neighbors.get(e.u).contains(e)) {
            return neighbors.get(e.u).add(e);
        } else {
            return false;
        }
    }

    @Override
    public boolean addEdge(int u, int v) throws IllegalArgumentException {
        return addEdge(new Edge(u, v));
    }
}
