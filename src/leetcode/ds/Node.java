package leetcode.ds;

import java.util.*;

/**
 * 图节点，邻接表
 * @author Achan
 * @date 2020/9/30
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public static Node buildGraphNode(int[][] arrays) {
        int n = arrays.length;
        HashMap<Integer, Node> nodeHashMap = new HashMap<>(n);
        for (int i = 1; i <= n; i++) {
            nodeHashMap.put(i, new Node(i));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                nodeHashMap.get(i + 1).neighbors.add(nodeHashMap.get(arrays[i][j]));
            }
        }
        return nodeHashMap.get(1);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return val == node.val &&
                neighbors.equals(node.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, neighbors);
    }

    public List<List<Node>> dfs() {
        ArrayList<List<Node>> result = new ArrayList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        dfs(this, result, map);
        return result;
    }

    private void dfs(Node node, ArrayList<List<Node>> result, Map<Integer, Node> map) {
        if (node == null) {
            return;
        }
        if (map.containsKey(node.val)) {
            return;
        }
        result.add(node.val - 1, node.neighbors);
        map.put(node.val, node);
        node.neighbors.forEach(n -> dfs(n, result, map));
    }

    public List<List<Node>> bfs() {
        ArrayList<List<Node>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(this.val, this);
        queue.offer(this);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            result.add(temp.neighbors);
            temp.neighbors.forEach(node -> {
                if (map.containsKey(node.val)) {
                    return;
                }
                queue.offer(node);
                map.put(node.val, node);
            });
        }
        return result;
    }
}
