package leetcode.package_104;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        return deep(root, 0);
    }

    int deep(TreeNode root, int value) {
        if (root == null) {
            return value;
        }

        return Math.max(deep(root.left, value + 1), deep(root.right, value + 1));
    }
}
