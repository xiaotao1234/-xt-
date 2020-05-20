package 数学;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/22 23:41
 */
public class 二的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}
