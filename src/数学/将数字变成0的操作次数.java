package 数学;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/18 22:50
 */
public class 将数字变成0的操作次数 {
    public int numberOfSteps(int num) {
        return get(num, 0);
    }

    public int get(int num, int s) {
        if (num == 0) {
            return s;
        }
        int ss;
        if (num % 2 == 0) {
            ss = get(num / 2, s + 1);
        } else {
            ss = get(num - 1, s + 1);
        }
        return ss;
    }
}
