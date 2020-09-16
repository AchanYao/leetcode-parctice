package package_1;

/**
 * Solution
 */
public class Solution {

    public int[] twoSum(int[] sums, int target) {
        for (int i = 0; i < sums.length; i++) {
            int temp = search(sums, target - sums[i], i);
            if (temp != -1) {
                return new int[] { i, temp };
            }
        }
        return new int[] {};
    }

    /**
     * 在数组中查找指定元素
     * 
     * @param sums   数组
     * @param target 目标元素
     * @param index 从指定下标开始寻找
     * @return 目标元素所在下标，如果不存在返回-1
     */
    public int search(int[] sums, int target, int index) {
        for (int i = index + 1; i < sums.length; i++) {
            if (sums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}