package leetcode.package_100;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
