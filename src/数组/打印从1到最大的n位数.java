package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/15 23:46
 */
public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int max = 1;
        int i = 0;
        while (i < n) {
            max = max * 10;
        }
        int[] s = new int[max - 1];
        for (int j = 1; j < max; j++) {
            s[j-1] = j;
        }
        return s;
    }
}
