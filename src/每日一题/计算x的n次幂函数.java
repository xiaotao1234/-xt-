package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/11 8:03
 */
public class 计算x的n次幂函数 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n > 0) {
            return dp(x, n);
        } else {
            return 1 / dp(x, n);
        }
    }

    public double dp(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int half = n / 2;
        double s = dp(x, n / 2);
        if (half * 2 == n) {
            return s * s;
        } else {
            return s * s * x;
        }
    }
}
