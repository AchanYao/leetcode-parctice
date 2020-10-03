package offer;

import leetcode.ds.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }

    @Test
    void isSymmetricTest() {
        System.out.println(isSymmetric(TreeNode.buildTree(1, 2, 2, 3, 4, 4, 3)));
    }
}
