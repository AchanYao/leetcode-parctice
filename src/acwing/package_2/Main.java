package acwing.package_2;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/4
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();

        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        int[] dp = new int[V];
        for (int i = 0; i < n; i++) {
            for (int j = V - 1; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j - w[i]] + v[i], dp[j]);
            }
        }
        System.out.println(dp[V]);
    }
}
