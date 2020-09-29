package leetcode.package_997;

/**
 * @author Achan
 * @date 2020/9/29
 */
public class Solution997 {

    public int findJudge(int N, int[][] trust) {
        int[] array = new int[N];
        int i = 0;
        while (i < trust.length) {
            array[trust[i][0] - 1] = -1;
            array[trust[i][1] - 1]++;
            i++;
        }
        int result = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[i] == N - 1) {
                result = array[i];
                break;
            }
        }
        return result;
    }
}
