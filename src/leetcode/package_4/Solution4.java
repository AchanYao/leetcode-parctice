package leetcode.package_4;

/**
 * Solution
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        // 如果m+n为奇数结果为第(m+n)/2个数
        // 如果m+n为偶数结果为第(m+n)/2和第(m + n)/2-1的平均数
        int[] temp = new int[2];
        int index = 0;
        while (i < m && j < n) {
            if (index == ((m + n) / 2 - 1)) {
                temp[0] = Math.min(nums1[i], nums2[j]);
            } else if (index == (m + n) / 2) {
                temp[1] = Math.min(nums1[i], nums2[j]);
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            index++;
        }
        while (i >= m && j < n) {
            if (index == ((m + n) / 2 - 1)) {
                temp[0] = nums2[j];
            } else if (index == (m + n) / 2) {
                temp[1] = nums2[j];
            }
            index++;
            j++;
        }
        while (i < m) {
            if (index == ((m + n) / 2 - 1)) {
                temp[0] = nums1[i];
            } else if (index == (m + n) / 2) {
                temp[1] = nums1[i];
            }
            index++;
            i++;
        }

        if ((m + n) % 2 != 0) {
            return temp[1];
        } else {
            return (temp[0] + temp[1]) / 2.0;
        }
    }

}