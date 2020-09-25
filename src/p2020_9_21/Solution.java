package p2020_9_21;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 58笔试
 *
 * @author Achan
 * @date 2020/9/21
 */
public class Solution {

    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + (arr[i] - '0');
                }
                i--;

                if (lastOp == '+') {
                    numStack.push(tempNum);
                } else if (lastOp == '-') {
                    numStack.push(-tempNum);
                } else {
                    numStack.push(res(lastOp, numStack.pop(), tempNum));
                }
            } else {
                lastOp = arr[i];
            }
        }

        int ans = 0;
        for (int num : numStack) {
            ans += num;
        }
        return ans;
    }

    private int res(char op, int a, int b) {
        if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        } else if (op == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }

    /**
     * 1. 1*2-3/4+5*6-7*8+9/10
     * 2. 2-0+30-56+0
     * 3. -24
     */
    @Test
    public void calculateTest() {
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }

    public int[] countBits(int num) {
        // write code here
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    @Test
    public void countBitsTest() {
        System.out.println(Arrays.toString(countBits(5)));
    }


    public ArrayList<Integer> mergerArrays(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>(Math.min(arrayA.size(), arrayB.size()));

        int i = 0;
        int j = 0;
        while (i < arrayA.size() && j < arrayB.size()) {
            int a = arrayA.get(i);
            int b = arrayB.get(j);
            if (a < b) {
                i++;
            } else if (a == b) {
                result.add(a);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }
}
