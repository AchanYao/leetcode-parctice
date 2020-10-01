package leetcode.package_113;

import leetcode.ds.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author Achan
 * @date 2020/9/30
 */
public class Solution113 {

    HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (nodeHashMap.containsKey(node.val)) {
            return nodeHashMap.get(node.val);
        }
        Node result = new Node(node.val);
        nodeHashMap.put(node.val, result);

        for (Node n : node.neighbors) {
            result.neighbors.add(cloneGraph(n));
        }
        return result;
    }

    @Test
    void cloneGraphTest() {
        Node node = Node.buildGraphNode(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        Node result = cloneGraph(node);
        result.dfs().stream().flatMap(mapper -> Stream.of(Arrays.toString(mapper.toArray()) + ", ")).forEach(System.out::print);
        System.out.println();
        result.bfs().stream().flatMap(mapper -> Stream.of(Arrays.toString(mapper.toArray()) + ", ")).forEach(System.out::print);
    }
}
