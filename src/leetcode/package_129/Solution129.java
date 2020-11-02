package leetcode.package_129;

import leetcode.ds.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/29
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        int temp = val * 10 + root.val;
        int valLeft = dfs(root.left, temp);
        int valRight = dfs(root.right, temp);
        if (valLeft + valRight == 0) {
            return temp;
        }
        return valLeft + valRight;
    }

    @Test
    void sumNumbersTest() {
        System.out.println(sumNumbers(TreeNode.buildTree(4, 9, 0, null, 1)));
    }
}
