package leetcode.package_290;

import java.util.HashMap;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution290 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        if (n != words.length) {
            return false;
        }
        String[] map = new String[26];
        HashMap<String, Character> hashMap = new HashMap<>(26);
        for (int i = 0; i < n; i++) {
            int index = pattern.charAt(i) - 'a';
            if (map[index] == null && !hashMap.containsKey(words[i])) {
                map[index] = words[i];
                hashMap.put(words[i], pattern.charAt(i));
            } else if (map[index] == null) {
                return false;
            } else if (!hashMap.containsKey(words[i])) {
                return false;
            } else {
                if (!map[index].equals(words[i]) || hashMap.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
