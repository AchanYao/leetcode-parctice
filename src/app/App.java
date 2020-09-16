package app;

import java.util.Scanner;

/**
 * @author Achan
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        int n = scanner.nextInt();
        int[][] tree = new int[n][3];
        for (int i = 0; i < n; i++) {
            tree[i][0] = scanner.nextInt();
            tree[i][1] = scanner.nextInt();
            tree[i][2] = scanner.nextInt();
        }
        int[] d = new int[n];
        d[0] = tree[0][2] * tree[0][2];
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + tree[i][2] * tree[i][2]);
        }
        result = d[n - 1];
        scanner.close();
        System.out.println(result);
    }
}