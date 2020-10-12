package leetcode.package_111;

import leetcode.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return bfs(root);
    }

    int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                if (temp.left == null && temp.right == null) {
                    return ans;
                }
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return ans;
    }

    int ans = Integer.MAX_VALUE;

    void dfs(TreeNode root, int deep) {
        if (root == null) {
            return;
        }

        deep++;
        if (root.right == null && root.left == null) {
            ans = Math.min(deep, ans);
        }
        dfs(root.left, deep);
        dfs(root.right, deep);
    }

}
