package acwing.package_1023;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/19
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] price = new int[] {10, 20, 50, 100};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int k : price) {
            for (int j = k; j <= n; j++) {
                dp[j] += dp[j - k];
            }
        }
        System.out.println(dp[n]);
    }
}
