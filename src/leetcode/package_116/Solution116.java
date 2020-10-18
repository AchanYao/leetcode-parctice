package leetcode.package_116;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution116 {
    public Node connect(Node root) {
        if (root == null) return null;

        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }

    void bfs(Node root) {
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node temp = deque.pollFirst();
                if (pre != null) {
                    pre.next = temp;
                }
                pre = temp;

                if (temp.left != null) {
                    deque.offerLast(temp.left);
                }
                if (temp.right != null) {
                    deque.offerLast(temp.right);
                }
            }
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
