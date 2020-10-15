package acwing.package_423;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt();

        int[] w = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int[] dp = new int[t + 1];
        for (int i = 0; i < m; i++) {
            for (int j = t; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        System.out.println(dp[t]);
    }
}
