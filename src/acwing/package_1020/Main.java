package acwing.package_1020;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/18
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE >>> 2);
        }
        dp[0][0] = 0;

        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            for (int j = m; j >= 0; j--) {
                for (int l = n; l >= 0; l--) {
                    dp[j][l] = Math.min(dp[j][l], dp[Math.max(j - a, 0)][Math.max(l - b, 0)] + c);
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
