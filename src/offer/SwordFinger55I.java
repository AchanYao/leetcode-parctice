package offer;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger55I {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode root, int current) {
        if (root == null) {
            return current;
        }
        return Math.max(maxDepth(root.left, current + 1), maxDepth(root.right, current + 1));
    }
}
