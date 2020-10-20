package acwing.package_1021;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/19
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            for (int j = v; j <= m; j++) {
                dp[j] += dp[j - v];
            }
        }
        System.out.println(dp[m]);
    }
}
