package offer;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger58I {

    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]).append(' ');
        }
        return builder.toString().trim();
    }
}
