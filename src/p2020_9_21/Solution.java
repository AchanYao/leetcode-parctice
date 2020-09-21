package p2020_9_21;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 58笔试
 * @author Achan
 * @date 2020/9/21
 */
public class Solution {

    public int calculate (String input) {
        // TODO 90%
        input = input.replace(" ", "");
        Stack<Integer> n = new Stack<>();
        Stack<Character> s = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c > '9' || c < '0') {
                if (c == '-' && n.size() == s.size()) {
                    flag = true;
                    continue;
                }
                if (!s.empty()) {
                    char t = s.peek();
                    if ((c == '*' || c == '/') && (t == '+' || t == '-')) {
                        // 栈顶元素优先级低，不计算
                    } else {
                        try {
                            n.push(calculate(n.pop(), n.pop(), s.pop()));
                        } catch (IllegalAccessException e) {
                            return 0;
                        }
                    }
                }
                s.push(c);
            } else {
                // 数字
                int end = i;
                for (; end < input.length(); end++) {
                    if (input.charAt(end) > '9' || input.charAt(end) < '0') {
                        break;
                    }
                }
                int temp = Integer.parseInt(input.substring(i, end));
                if (flag) {
                    n.push(-temp);
                    flag = false;
                } else {
                    n.push(temp);
                }
                i = end - 1;
            }
        }

        while (!s.empty()) {
            try {
                n.push(calculate(n.pop(), n.pop(), s.pop()));
            } catch (IllegalAccessException e) {
                return 0;
            }
        }
        return n.pop();
    }

    public int calculate(int a, int b, char c) throws IllegalAccessException {
        switch (c) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '/':
                return b / a;
            case '*':
                return b * a;
            default:
                throw new IllegalAccessException("错误运算符");
        }
    }

    @Test
    public void calculateTest() {
        System.out.println(calculate("100 + 2 * 3 + -11"));
    }

    public int[] countBits (int num) {
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


    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>(Math.min(arrayA.size(), arrayB.size()));

        int i = 0; int j = 0;
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
