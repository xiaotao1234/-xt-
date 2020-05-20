package 二分查找;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/27 22:52
 */
public class 搜索二维矩阵2 {

    public static void main(String[] args) {
        搜索二维矩阵2 s = new 搜索二维矩阵2();
        s.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (true) {
            int i1 = 0;
            int j1 = 0;
            if (matrix[i][j] > target) {
                j1 = -1;
            } else if (matrix[i][j] < target) {
                i1 = 1;
            } else {
                return true;
            }
            i = i + i1;
            j = j + j1;
            if (j < 0 || i >= matrix.length) {
                return false;
            }
        }
    }
}
