package 双周赛25;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/4 22:54
 */
public class 检查一个字符串是否可以打破另一个字符串 {

    public static void main(String[] args) {
        检查一个字符串是否可以打破另一个字符串 s = new 检查一个字符串是否可以打破另一个字符串();
        s.checkIfCanBreak("abe","acd");
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = new char[s1.length()];
        char[] chars2 = new char[s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            chars1[i] = s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            chars2[i] = s2.charAt(i);
        }
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (chars1[0] > chars2[0] &&
                chars1[chars1.length - 1] < chars2[chars2.length - 1] ||
                chars1[0] < chars2[0] &&
                        chars1[chars1.length - 1] > chars2[chars2.length - 1]) {
            return false;
        } else {
            int k = 0;
            while (k < s1.length()) {
                if (chars1[k] > chars2[k]) {
                    int j = k + 1;
                    while (j < s1.length()) {
                        if (chars1[j] < chars2[j]) {
                            return false;
                        }
                        j++;
                    }
                    break;
                } else if (chars1[k] < chars2[k]) {
                    int j = k + 1;
                    while (j < s1.length()) {
                        if (chars1[j] > chars2[j]) {
                            return false;
                        }
                        j++;
                    }
                    break;
                } else {
                    k++;
                }
            }
        }
        return true;
    }
}
