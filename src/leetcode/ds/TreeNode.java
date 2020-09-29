package leetcode.ds;

/**
 * @author Achan
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static TreeNode buildTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        for (int i = 0; i < values.length; i++) {
            insert(root, values[i], i);
        }
        return root;
    }

    private static void insert(TreeNode root, Integer val, int index) {
        if (val == null) {
            return;
        }
        if (index == 0) {
            root.val = val;
            return;
        }
        byte[] bytes = new byte[index];
        int current = index;
        int i = 0;
        for (; current != 0; i++) {
            bytes[i] = (byte) (current & 1);
            current = (current - 1) / 2;
        }
        TreeNode parent = null;
        TreeNode currentNode = root;
        for (int j = i - 1; j >= 0; j--) {
            parent = currentNode;
            if (bytes[j] == 0) {
                currentNode = parent.right;
            } else {
                currentNode = parent.left;
            }
        }
        if (parent == null) {
            parent = root;
        }
        if (bytes[0] == 0) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
    }
}
