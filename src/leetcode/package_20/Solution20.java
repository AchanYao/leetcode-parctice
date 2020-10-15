package leetcode.package_20;

/**
 * @author Achan
 * @date 2020/10/14
 */
public class Solution20 {

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c :
                s.toCharArray()) {
            switch (c) {
                case '(':
                    stack[head++] = ')';
                    break;
                case '{':
                    stack[head++] = '}';
                    break;
                case '[':
                    stack[head++] = ']';
                    break;
                case ')':
                    break;
                case '}':
                case ']': {
                    if (head == 0 || stack[--head] != c) {
                        return false;
                    }
                }
                break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return head == 0;
    }
}
