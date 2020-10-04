package offer;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int from, int to) {
        if (from >= to) return true;
        int rightStart = to - 1;
        while (rightStart > from) {
            if (postorder[rightStart] < postorder[to]) {
                break;
            }
            rightStart--;
        }
        for (int i = rightStart - 1; i >= from; i--) {
            if (postorder[i] > postorder[to]) {
                return false;
            }
        }
        return verifyPostorder(postorder, rightStart, to - 1) && verifyPostorder(postorder, from, rightStart - 1);
    }

    @Test
    void verifyPostorderTest() {
        System.out.println(verifyPostorder(new int[]{3, 10, 6, 9, 2}));
    }
}
