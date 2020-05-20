package 数学;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/1 23:06
 */
public class 各位相加 {
    public int addDigits(int num) {
        while (num > 9) {
            num = get(num);
        }
        return num;
    }

    public int get(int num) {
        int all = 0;
        while (num != 0) {
            all = all + num % 10;
            num = num / 10;
        }
        return all;
    }
}
