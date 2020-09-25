package ds.heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Achan
 * @date 2020/9/22
 */
public class MaxRootHeap<E extends Comparable<E>> {

    private final ArrayList<E> arrayList;

    public MaxRootHeap() {
        arrayList = new ArrayList<>();
    }

    public MaxRootHeap(int initSize) {
        arrayList = new ArrayList<>(initSize);
    }

    public MaxRootHeap(Collection<E> collection) {
        arrayList = new ArrayList<>(collection.size());
        for (E element : collection) {
            add(element);
        }
    }

    public MaxRootHeap(E... arrays) {
        arrayList = new ArrayList<>(arrays.length);
        for (E element : arrays) {
            add(element);
        }
    }

    public void add(E node) {
        arrayList.add(node);
        int parentIndex = (arrayList.size() - 2) / 2;
        while (node.compareTo(arrayList.get(parentIndex)) > 0) {
            // 大于，交换
            change(parentIndex, arrayList.indexOf(node));
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    public E remove() {
        if (arrayList.size() == 0) {
            return null;
        }
        if (arrayList.size() == 1) {
            return arrayList.remove(0);
        }
        E lastNode = arrayList.remove(arrayList.size() - 1);
        E firstNode = arrayList.remove(0);
        arrayList.add(0, lastNode);
        int childIndex = 0;
        while (childIndex < arrayList.size()) {
            int maxIndex = max(childIndex * 2 + 1, childIndex * 2 + 2);
            if (maxIndex == -1) {
                break;
            }
            if (arrayList.get(maxIndex).compareTo(arrayList.get(childIndex)) < 0) {
                break;
            }
            change(childIndex, maxIndex);
            childIndex = maxIndex;
        }
        return firstNode;
    }

    private void change(int index1, int index2) {
        int min = Math.min(index1, index2);
        int max = Math.max(index1, index2);
        arrayList.add(min, arrayList.get(max));
        arrayList.remove(max + 1);
        arrayList.add(max + 1, arrayList.get(min + 1));
        arrayList.remove(min + 1);
    }

    public int size() {
        return arrayList.size();
    }

    private int max(int index1, int index2) {
        int size = arrayList.size();
        if (index1 >= size && index2 >= size) {
            return -1;
        }
        if (index1 < size && index2 >= size) {
            return index1;
        }
        if (index1 >= size && index2 < size) {
            return index2;
        }
        if (arrayList.get(index1).compareTo(arrayList.get(index2)) > 0) {
            return index1;
        } else {
            return index2;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayList.toArray());
    }
}

class MaxRootHeapTest {

    @Test
    public void addTest() {
        MaxRootHeap<Integer> heap = new MaxRootHeap<>();
        int[] array = new int[]{75, 613, 436, 622, 424, 72, 934, 123, 888, 391};
        System.out.println(Arrays.toString(array));
        for (int j : array) {
            heap.add(j);
        }
        System.out.println(heap);
    }

    @Test
    public void removeTest() {
        MaxRootHeap<Integer> heap = new MaxRootHeap<>(75, 613, 436, 622, 424, 72, 934, 123, 888, 391);
        System.out.println(heap);
        while (heap.size() != 0) {
            heap.remove();
            System.out.println(heap);
        }
    }
}
