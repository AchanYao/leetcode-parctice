package ds.uf;

/**
 * @author Achan
 * @date 2020/10/21
 */
public class UnionFind {

    private final int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int e) {
        int temp = parent[e];
        while (e != temp) {
            temp = parent[temp];
            e = parent[e];
        }
        return e;
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }
}
