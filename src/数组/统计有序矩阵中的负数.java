package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/23 23:15
 */
public class 统计有序矩阵中的负数 {

    public static void main(String[] args) {
        统计有序矩阵中的负数 s1 = new 统计有序矩阵中的负数();
        System.out.println(s1.countNegatives(new int[][]{{-1}}));
    }

    public int countNegatives(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int all = 0;
        while (i < grid.length && j < grid[0].length) {
            while (j < grid[0].length && grid[i][j] >= 0) {
                j++;
                all++;
            }
            j = 0;
            i++;
        }
        return grid.length * grid[0].length - all;
    }
}
