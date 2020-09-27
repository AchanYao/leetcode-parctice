package offer;

/**
 * @author Achan
 * @date 2020/9/27
 */
public class SwordFinger26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return f(A, B) || isSubStructure(A.right, B) || isSubStructure(A.left, B);
    }

    public boolean f(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return b.val == a.val && f(a.left, b.left) && f(a.right, b.right);
    }
}
