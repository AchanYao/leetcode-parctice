package acwing.package_8;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int M = scanner.nextInt();

        int[] v = new int[N];
        int[] m = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = scanner.nextInt();
            m[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        int[][] dp = new int[V + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
                }
            }
        }

        System.out.println(dp[V][M]);
    }
}
