package 每日一题;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/15 8:25
 */
public class 矩阵 {
    public static void main(String[] args) {
        矩阵 s = new 矩阵();
        int[][] a = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(s.updateMatrix(a));
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] target = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> stack = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    stack.add(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] s = stack.poll();
            for (int i = 0; i < 4; i++) {
                int ni = s[0] + target[i][0];
                int nj = s[1] + target[i][1];
                if (ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length && matrix[ni][nj] == -1) {
                    matrix[ni][nj] = matrix[s[0]][s[1]] + 1;
                    stack.add(new int[]{ni, nj});
                }
            }
        }
        return matrix;
    }
}
