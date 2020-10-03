package offer;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger54 {

    int k;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res;
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
            return;
        }
        inOrder(root.left);
    }
}
