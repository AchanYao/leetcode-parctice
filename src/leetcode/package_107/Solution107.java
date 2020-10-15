package leetcode.package_107;

import leetcode.ds.TreeNode;

import java.util.*;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    throw new NullPointerException();
                }
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(list);
        }

        Collections.reverse(res);
        return res;
    }
}
