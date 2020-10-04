package offer;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class SwordFinger58II {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
