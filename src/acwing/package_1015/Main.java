package acwing.package_1015;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2020/10/2
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t > 0) {
            t--;
            int[][] map = new int[scanner.nextInt()][scanner.nextInt()];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solution(map));
        }
        scanner.close();
    }

    static int solution(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) + map[i][j];
            }
        }
        return dp[m][n];
    }
}
