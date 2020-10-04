package offer;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger55II {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.right, 0) - maxDepth(root.left, 0)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root, int current) {
        if (root == null) {
            return current;
        }
        return Math.max(maxDepth(root.left, current + 1), maxDepth(root.right, current + 1));
    }
}
