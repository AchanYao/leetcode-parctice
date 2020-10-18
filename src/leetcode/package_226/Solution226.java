package leetcode.package_226;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
