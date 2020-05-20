package 其他;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 22:26
 */
public class Nim游戏 {
    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}
