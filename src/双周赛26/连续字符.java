package 双周赛26;

import 各种排序方法.数组中的第K个最大元素;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 22:30
 */
public class 连续字符 {

    public static void main(String[] args) {
        连续字符 s = new 连续字符();
        System.out.println(s.maxPower("hooraaaaaaaaaaay"));
    }

    public int maxPower(String s) {
        int max = 1;
        int now = 1;
        char head = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == head) {
                now = now + 1;
                max = Math.max(max, now);
            }else {
                now = 1;
                head = s.charAt(i);
            }
        }
        return max;
    }
}
