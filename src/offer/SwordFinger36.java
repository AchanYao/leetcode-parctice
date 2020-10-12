package offer;

/**
 * @author Achan
 * @date 2020/10/10
 */
public class SwordFinger36 {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (head == null) {
            head = root;
        }
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        inorder(root.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
