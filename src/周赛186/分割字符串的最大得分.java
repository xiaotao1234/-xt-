package 周赛186;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/26 11:04
 */
public class 分割字符串的最大得分 {

    public static void main(String[] args) {
        分割字符串的最大得分 s = new 分割字符串的最大得分();
        System.out.println(s.maxScore("00111"));
    }

    public int maxScore(String s) {
        int o = 0;
        int l = 0;
        int max = 0;
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i) == '1') {
                l++;
            }
        }
        max = Math.max(max, o + l);
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                o++;
            } else {
                l--;
            }
            max = Math.max(max, o + l);
        }
        if (s.charAt(0) == '0') {
            max++;
        }
        if (s.charAt(s.length() - 1) == '1') {
            max++;
        }
        return max;
    }
}
