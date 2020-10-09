package acwing.package_1024;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int[] dp = new int[v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= w[i]; j--) {
                    dp[j] = Math.max(dp[j - w[i]] + w[i], dp[j]);
            }
        }
        System.out.println(v - dp[v]);
    }
}
