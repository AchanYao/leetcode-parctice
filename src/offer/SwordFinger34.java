package offer;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/10
 */
public class SwordFinger34 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int temp = sum - root.val;
        if (temp == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
        path.removeLast();
    }
}
