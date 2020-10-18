package leetcode.package_383;

/**
 * @author Achan
 * @date 2020/10/16
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length();
        int m = magazine.length();
        if (m < n) {
            return false;
        }
        int[] map = new int[26];
        int i = 0;
        while (i < n) {
            map[ransomNote.charAt(i) - 'a']--;
            map[magazine.charAt(i) - 'a']++;
            i++;
        }
        while (i < m) {
            map[magazine.charAt(i) - 'a']++;
            i++;
        }
        for (i = 0; i < map.length; i++) {
            if (map[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
