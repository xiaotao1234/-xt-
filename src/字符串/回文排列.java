package 字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/23 23:09
 */
public class 回文排列 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            if (!set.contains(ss)) {
                set.add(ss);
            } else {
                set.remove(ss);
            }
        }
        if (set.size() <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
