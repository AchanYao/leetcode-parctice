package acwing.package_12;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/19
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        int[][] dp = new int[N + 1][V + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = V; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - v[i]] + w[i]);
                }
            }
        }

        int j = V;
        for (int i = 0; i < N; i++) {
            if (j >= v[i] && dp[i][j] == dp[i + 1][j - v[i]] + w[i]) {
                System.out.print((i + 1) + " ");
                j -= v[i];
            }
        }
    }
}
