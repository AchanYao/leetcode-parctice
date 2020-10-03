package offer;

import leetcode.ds.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger32III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new LinkedList<>();
        int deep = 0;
        while (!queue.isEmpty()) {
            deep++;
            List<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                assert t != null;
                levelList.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            if ((deep & 1) == 0) {
                Collections.reverse(levelList);
            }
            result.add(levelList);
        }
        return result;
    }
}
