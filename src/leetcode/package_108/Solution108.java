package leetcode.package_108;

import leetcode.ds.TreeNode;

/**
 * @author Achan
 * @date 2020/10/15
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int from, int to) {
        if (from > to || nums == null || nums.length == 0) {
            return null;
        }
        int mid = (to - from) / 2 + from;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, from, mid - 1);
        root.right = build(nums, mid + 1, to);
        return root;
    }
}
