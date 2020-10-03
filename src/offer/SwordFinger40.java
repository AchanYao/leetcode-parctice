package offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Achan
 * @date 2020/10/3
 */
public class SwordFinger40 {

    public int[] getLeastNumbersByHeap(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int[] result = new int[k];
        for (int i : arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(i);
            } else if (i < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(i);
            }
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            result[i++] = priorityQueue.poll();
        }
        return result;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left < right) {
            index = onceSort(arr, left, right);
            if (index == k) {
                break;
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    /**
     * 进行一次快排
     *
     * @param a     数组
     * @param left  最左边下标
     * @param right 最右边下标
     * @return 基数最终下标
     */
    public int onceSort(int[] a, int left, int right) {
        Random random = new Random();
        int baseIndex = random.nextInt(right - left) + left;
        int firstMore = right;
        int lastLess = Integer.MIN_VALUE;
        int base = a[baseIndex];
        swap(a, left, baseIndex);
        for (int i = left + 1; i <= right; ++i) {
            if (a[i] < base) {
                lastLess = i;
                if (lastLess > firstMore) {
                    swap(a, lastLess, firstMore);
                    lastLess = firstMore;
                    firstMore++;
                }
            } else if (a[i] > base) {
                firstMore = Math.min(firstMore, i);
            }
        }
        swap(a, lastLess, left);
        return Math.max(lastLess, left);
    }

    private void swap(int[] array, int a, int b) {
        if (a < 0 || a > array.length || b < 0 || b > array.length) return;
        if (a == b) return;
        array[a] = array[a] ^ array[b];
        array[b] = array[a] ^ array[b];
        array[a] = array[a] ^ array[b];
    }

    @Test
    void getLeastNumbersTest() {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 2)));
    }
}
