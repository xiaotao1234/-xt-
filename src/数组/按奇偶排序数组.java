package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/20 23:36
 */
public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] A) {
        int right = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                if (right != -1) {
                    int target = A[i];
                    A[i] = A[right];
                    A[right] = target;
                    right = -1;
                }
            } else {
                right = i;
            }
        }
        return A;
    }
}
