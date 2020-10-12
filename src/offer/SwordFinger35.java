package offer;

import java.util.HashMap;

/**
 * @author Achan
 * @date 2020/10/10
 */
public class SwordFinger35 {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> cache = new HashMap<>();
        Node current = head;
        Node result = copy(head);
        Node resultCurrent = result;
        cache.put(current, resultCurrent);
        while (current != null) {
            current = current.next;
            resultCurrent.next = copy(current);
            resultCurrent = resultCurrent.next;
            cache.put(current, resultCurrent);
        }

        current = head;
        resultCurrent = result;
        while (current != null) {
            if (current.random != null) {
                resultCurrent.random = cache.get(current.random);
            }
            current = current.next;
            resultCurrent = resultCurrent.next;
        }

        return result;
    }

    Node copy(Node node) {
        if (node == null) return null;
        return new Node(node.val);
    }
}
