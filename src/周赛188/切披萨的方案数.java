package 周赛188;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/10 11:33
 */
public class 切披萨的方案数 {

    public static void main(String[] args) {
        切披萨的方案数 s = new 切披萨的方案数();
        System.out.println(s.ways(new String[]{"A..", "AAA", "..."}, 3));
    }

    public int ways(String[] pizza, int k) {
        int[][] num = getnum(pizza);
        int[][][] dp = new int[num.length-1][num[0].length-1][k];
        dp[0][0][0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int m = 0; m < k - 1; m++) {
                    if (dp[i][j][m] > 0) {
                        for (int n = i + 1; n < dp.length; n++) {
                            if (hasApple(num, i, j, n, j)) {
                                dp[n][j][m + 1] = dp[n][j][m + 1] + dp[i][j][m];
                            }
                        }
                        for (int n = j + 1; n < dp[0].length; n++) {
                            if (hasApple(num, i, j, i, n)) {
                                dp[i][n][m + 1] = dp[i][n][m + 1] + dp[i][j][m];
                            }
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1][k - 1];
    }

    public boolean hasApple(int[][] num, int x, int y, int x1, int y1) {
        if (num[num.length - 1][num[0].length - 1] > num[x1 + 1][y1 + 1]
                && num[x1 + 1][y1 + 1] > num[x + 1][y + 1]) {
            return true;
        }
        return false;
    }

    public int[][] getnum(String[] pizza) {
        int[][] num = new int[pizza.length + 1][pizza[0].length() + 1];
        for (int i = 1; i <= pizza.length; i++) {
            for (int j = 1; j <= pizza[0].length(); j++) {
                num[i][j] = num[i - 1][j] + num[i][j - 1] - num[i - 1][j - 1] + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            }
        }
        return num;
    }

    public boolean get(int left, int top, int right, int bottom, String[] pizza, boolean hen, int where) {//暴力求解一定范围内是否存在苹果
        if (hen) {//横切
            for (int i = top; i <= where; i++) {
                for (int j = left; j <= right; j++) {
                    if (pizza[i].charAt(j) == 'A') {
                        return true;
                    }
                }
            }
        } else {
            for (int i = top; i <= bottom; i++) {
                for (int j = left; j <= where; j++) {
                    if (pizza[i].charAt(j) == 'A') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
