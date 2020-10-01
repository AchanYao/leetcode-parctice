package acwing.package_1010;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/1
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = inputs.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int[] dp = new int[n];
        int[] g = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (k < count && g[k] < nums[i]) {
                k++;
            }
            g[k] = nums[i];
            if (k >= count) {
                count++;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }
}
