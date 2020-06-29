package 周赛184;

import 贪心.无重叠区间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/12 10:30
 */
public class 数组中的字符串匹配 {

    public static void main(String[] args) {
        数组中的字符串匹配 s = new 数组中的字符串匹配();

        System.out.println(s.stringMatching(new String[]{"leetcode", "et", "code"}));
    }

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i) {
                    if (isContains(words[i], words[j])) {
                        if(!list.contains(words[j]))
                        list.add(words[j]);
                    }
                }
            }
        }
        return list;
    }

    public boolean isContains(String s1, String s2) {
        if (s1.length() > s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s2.charAt(0) == s1.charAt(i)) {
                    int k = 0;
                    while (i + k < s1.length() && s1.charAt(i + k) == s2.charAt(k)) {
                        if (k == s2.length() - 1) {
                            return true;
                        }
                        k++;
                    }
                }
            }
        }
        return false;
    }
}
