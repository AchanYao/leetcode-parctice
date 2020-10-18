package leetcode.package_110;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(rightHeight, leftHeight);
    }
}
