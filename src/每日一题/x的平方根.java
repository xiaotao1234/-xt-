package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/9 21:37
 */
public class x的平方根 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 - 1;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long seq = mid * mid;
            if (seq > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
