package acwing.package_278;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/12
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= nums[i]; j--) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - nums[i]] + nums[i]);
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[n][m]);
    }
}
