package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/16 0:02
 */
public class 数组中的最长山脉 {

    public static void main(String[] args) {
        数组中的最长山脉 s1 = new 数组中的最长山脉();
        System.out.println(s1.longestMountain(new int[]{2, 3, 3, 2, 0, 2}));
    }

    public int longestMountain(int[] A) {
        boolean up = true;
        int len = 1;
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (up && A[i] > A[i - 1]) {
                len++;
            } else if (!up && A[i] < A[i - 1]) {
                len++;
            } else if (up && A[i] < A[i - 1] && len > 1) {
                up = false;
                len++;
            } else if (!up && A[i] != A[i - 1]) {
                up = true;
                max = Math.max(max, len);
                len = 1;
                i--;
            } else if (A[i] == A[i - 1]) {
                up = true;
                max = Math.max(max, len);
                len = 1;
            }
        }
        if (!up)
            max = Math.max(max, len);
        if (max < 3) {
            return 0;
        }
        return max;
    }
}
