package acwing.package_1020;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/2
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], (int) 1e4);
        }
        dp[1][1] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]) + map[i][j]);
            }
        }
        System.out.println(dp[n][n]);
    }
}
