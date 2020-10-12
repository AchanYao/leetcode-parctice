package acwing.package_6;

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
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
            num[i] = scanner.nextInt();
        }

        int[] dp = new int[v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= weight[i]; j--) {
                for (int k = 1; k <= num[i] && k <= j / weight[i]; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        System.out.println(dp[v]);
    }
}
