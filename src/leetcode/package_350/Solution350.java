package leetcode.package_350;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/11/2
 */
public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = Math.min(n, m);
        int[] res = new int[len];
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int count = 0;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                res[count++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOf(res, count);
    }

}
