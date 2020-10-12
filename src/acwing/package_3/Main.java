package acwing.package_3;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/11
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[] dp = new int[v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <= v; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[v]);
    }
}
