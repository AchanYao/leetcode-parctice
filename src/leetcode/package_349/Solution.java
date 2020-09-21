package leetcode.package_349;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Achan
 * @date 2020/9/20
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> temp = new HashSet<>(nums1.length + nums2.length);
        HashSet<Integer> temp2 = new HashSet<>(nums1.length + nums2.length);
        HashSet<Integer> result = new HashSet<>(Math.min(nums1.length, nums2.length));
        for (int k : nums1) {
            temp.add(k);
        }
        for (int j : nums2) {
            temp2.add(j);
        }
        temp2.forEach(e -> {
            if (!temp.add(e)) {
                result.add(e);
            }
        });
        int[] a = new int[result.size()];
        AtomicInteger index = new AtomicInteger();
        result.forEach(e -> a[index.getAndIncrement()] = e);
        return a;
    }

    @Test
    public void intersectionTest() {
        System.out.println(Arrays.toString(intersection(new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4}, new int[]{4, 7, 9, 7, 6, 7})));
    }
}
