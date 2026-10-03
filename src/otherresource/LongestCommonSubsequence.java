package otherresource;

import java.util.Arrays;

public class LongestCommonSubsequence {
    void main() {
        char[] arrWord1 = "fish".toCharArray();
        char[] arrWord2 = "fosh".toCharArray();

        int[][] dp = new int[arrWord1.length + 1][arrWord2.length + 1];


        for (int i = 1; i < arrWord1.length + 1; ++i) {

            for (int j = 1; j < arrWord2.length + 1; ++j) {
                if (arrWord1[i - 1] == arrWord2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


}
