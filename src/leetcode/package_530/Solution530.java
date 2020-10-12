package leetcode.package_530;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution530 {

    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (pre != -1)
            ans = Integer.min(Math.abs(root.val - pre), ans);
        pre = root.val;
        dfs(root.right);
    }
}
