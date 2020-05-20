package 字符串;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/21 21:51
 */
public class 字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        字符串中的第一个唯一字符 s = new 字符串中的第一个唯一字符();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] ints = new int[26];
        Arrays.fill(ints, -1);
        for (int i = 0; i < s.length(); i++) {
            char m = s.charAt(i);
            if (ints[m - 97] == -1) {
                ints[m - 97] = i;
            } else {
                ints[m - 97] = -2;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : ints) {
            if (i >= 0) {
                int ints1 = ints[s.charAt(i) - 97];
                if (ints1 >= 0) {
                    min = Math.min(min, ints1);
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;
    }
}
