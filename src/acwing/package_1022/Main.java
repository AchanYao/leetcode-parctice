package acwing.package_1022;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] num = new int[k];
        int[] heal = new int[k];

        for (int i = 0; i < k; i++) {
            num[i] = scanner.nextInt();
            heal[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            for (int j = n; j >= num[i]; j--) {
                for (int l = m - 1; l >= heal[i]; l--) {
                    dp[j][m] = Math.max(dp[j - num[i]][l - heal[i]] + 1, dp[l][m]);
                }
            }
        }
        int t = m - 1;
        while (t > 0 && dp[n][m - 1] == dp[n][t - 1]) {
            t--;
        }
        System.out.printf("%d %d", dp[n][m - 1], m - t);
    }
}
