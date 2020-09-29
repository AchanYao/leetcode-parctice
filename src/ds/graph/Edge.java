package ds.graph;

/**
 * 边对象
 * @author Achan
 * @date 2020/9/29
 */
public class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge edge = (Edge) o;

        if (u != edge.u) {
            return false;
        }
        return v == edge.v;
    }

    @Override
    public int hashCode() {
        int result = u;
        result = 31 * result + v;
        return result;
    }
}
