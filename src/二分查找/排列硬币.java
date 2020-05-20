package 二分查找;

import 动态规划或贪心.阶梯125跳;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/12 20:35
 */
public class 排列硬币 {

    public static void main(String[] args) {
        排列硬币 s = new 排列硬币();
        System.out.println(s.arrangeCoins(6));
    }

    public int arrangeCoins(int n) {
        int l = 0;
        int m = 2;
        while (n >= m - 1) {
            m = m * 2;
            l++;
        }
        return l;
    }
}
