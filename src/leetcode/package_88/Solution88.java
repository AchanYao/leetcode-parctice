package leetcode.package_88;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution88 {

    /**
     * <p>合并两个有序数组nums1跟nums2，假设nums有足够空间（m+n）</p>
     * <p>时间O(m+n)空间O(1)</p>
     * @param nums1 数组1
     * @param m nums1的长度
     * @param nums2 数组2
     * @param n nums2的长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = n;
        /*
        数组有序，说明最大值只会是nums1[i - 1]和nums2[j - 1]中的一个，该值所在位置应该为nums1[i + j - 1]
         */
        while (j > 0 && i > 0) {
            // 最大值为nums2[j - 1];
            if (nums1[i - 1] <= nums2[j - 1]) {
                // 保存该值
                nums1[i + j - 1] = nums2[j - 1];
                // 指针前移
                j--;
            } else {
                // 最大值为nums1[i - 1];
                nums1[i + j - 1] = nums1[i - 1];
                i--;
            }
        }
        // 将剩余值填入数组中
        while (j > 0) {
            nums1[i + j - 1] = nums2[j - 1];
            j--;
        }
        while (i > 0) {
            nums1[i + j - 1] = nums1[i - 1];
            i--;
        }
    }
}
