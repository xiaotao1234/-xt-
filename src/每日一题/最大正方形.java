package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/8 1:33
 */
public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] ints = new int[matrix.length + 1][matrix[0].length + 1];
        int maxSide = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    ints[i + 1][j + 1] = Math.min(ints[i][j], Math.min(ints[i][j + 1], ints[i + 1][j])) + 1;
                    maxSide = Math.max(maxSide, ints[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
