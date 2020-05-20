package 字符串;

import 拓扑排序.课程表2;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/19 18:33
 */
public class 验证回文字符串2 {

    public static void main(String[] args) {
        验证回文字符串2 s = new 验证回文字符串2();
        System.out.println(s.validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        return get(s, 0, s.length() - 1, false);
    }

    public boolean get(String s, int left, int right, boolean sss) {
        if (left >= right) {
            return true;
        }
        boolean m;
        if (s.charAt(left) == s.charAt(right)) {
            m = get(s, left + 1, right - 1, sss);
        } else if (!sss) {
            m = get(s, left, right - 1, true) || get(s, left + 1, right, true);
        } else {
            return false;
        }
        return m;
    }
}
