package leetcode.package_101;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/9/29
 */
public class Solution101 {

        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
}
