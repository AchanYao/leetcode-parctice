package offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2020/9/25
 */
public class SwordFinger13 {

    public int movingCount(int m, int n, int k) {

        if (k == 0) {
            return 1;
        }
        byte[][] visited = new byte[m][n];
        int result = dfs(0, 0, m, n, visited, k);
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        return result;
    }

    public int bitSum(int i) {
        int sum = i % 10;
        int tmp = i / 10;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }

    public int dfs(int i, int j, int m, int n, byte[][] visited, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || bitSum(i) + bitSum(j) > k) {
            return 0;
        }
        visited[i][j] = 1;
        return 1 + dfs(i + 1, j, m, n, visited, k) + dfs(i, j + 1, m, n, visited, k);
    }

    @Test
    public void movingCountTest() {
        Assertions.assertEquals(135, movingCount(38, 15, 9));
    }
}
