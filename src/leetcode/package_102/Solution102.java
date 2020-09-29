package leetcode.package_102;

import leetcode.ds.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Achan
 * @date 2020/9/29
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    @Test
    void levelOrderTest() {
        TreeNode root = TreeNode.buildTree(3,9,20,null,null,15,7);
        levelOrder(root).forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
}