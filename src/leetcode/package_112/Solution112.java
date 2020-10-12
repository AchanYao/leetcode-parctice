package leetcode.package_112;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null && root.val == sum) {
            return true;
        }
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
