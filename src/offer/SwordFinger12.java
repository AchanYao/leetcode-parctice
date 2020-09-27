package offer;

import org.junit.jupiter.api.Test;

/**
 * @author Achan
 * @date 2020/9/25
 */
public class SwordFinger12 {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == chars[0] && dfs(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] source, int i, int j, char[] word, int index) {
        int n = source.length;
        int m = source[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || source[i][j] != word[index]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        char temp = source[i][j];
        source[i][j] = '#';
        boolean result = dfs(source, i - 1, j, word, index + 1)
                || dfs(source, i + 1, j, word, index + 1)
                || dfs(source, i, j - 1, word, index + 1)
                || dfs(source, i, j + 1, word, index + 1);
        if (!result) {
            source[i][j] = temp;
        }
        return result;
    }

    @Test
    public void existTest() {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
