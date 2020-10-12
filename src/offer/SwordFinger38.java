package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Achan
 * @date 2020/10/11
 */
public class SwordFinger38 {

    List<String> result = new LinkedList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return result.toArray(new String[0]);
    }

    void dfs(int x) {
        if (x == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    void swap(int i, int j) {
        if (i == j) return;
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
