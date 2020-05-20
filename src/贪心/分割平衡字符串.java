package 贪心;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/11 8:06
 */
public class 分割平衡字符串 {
    public int balancedStringSplit(String s) {
        int left = 0;
        int right = 0;
        int all = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                all++;
                left = 0;
                right = 0;
            }
        }
        return all;
    }
}
