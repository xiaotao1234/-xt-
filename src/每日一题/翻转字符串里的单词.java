package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        翻转字符串里的单词 s = new 翻转字符串里的单词();
        System.out.println(s.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        int start = 0;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (i - start != 0) {
                    strings.add(s.substring(start, i + 1));
                    start = i + 1;
                } else {
                    start = i + 1;
                }
            }
        }
        strings.add(s.substring(start) + " ");
        String ss = "";
        for (String sss : strings) {
            ss = sss + ss;
        }
        return ss.trim();
    }

    public void get(String s, int now) {
        if (now == s.length()) {
            return;
        }

    }
}
