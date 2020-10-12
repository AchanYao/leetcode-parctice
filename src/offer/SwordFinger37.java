package offer;

import leetcode.ds.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Achan
 * @date 2020/10/10
 */
public class SwordFinger37 {
    public static void main(String[] args) {
        SwordFinger37 t = new SwordFinger37();
        TreeNode treeNode = t.deserialize("[5, 2, 3, null, null, 2, 4, 3, 1]");
        System.out.println(t.serialize(treeNode));
    }

    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        LinkedList<String> bfs = bfs(root);
        return Arrays.toString(bfs.toArray());
    }

    private LinkedList<String> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    result.add("null");
                } else {
                    result.add(String.valueOf(temp.val));
                }
                if (temp != null) {
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }

    public TreeNode rdeserialize(String... values) {
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        while (i < values.length) {
            // 出队一个元素
            TreeNode temp = queue.poll();
            if (temp == null) throw new NullPointerException("i = " + i);

            String leftVal = values[i];
            String rightVal = values[i + 1];
            if (!"null".equals(leftVal)) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(leftVal));
                temp.left = leftNode;
                queue.offer(leftNode);
            }

            if (!"null".equals(rightVal)) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(rightVal));
                temp.right = rightNode;
                queue.offer(rightNode);
            }

            i += 2;
        }
        return root;
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String[] dataArray = data.replaceAll("\\s*", "").replace("[", "").replace("]", "").split(",");
        return rdeserialize(dataArray);
    }
}
