package 周赛190;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/24 10:50
 */
public class 定长子串中元音的最大数目 {
    public static void main(String[] args) {
        定长子串中元音的最大数目 s = new 定长子串中元音的最大数目();
        s.maxVowels("weallloveyou", 7);
    }

    public int maxVowels(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                max++;
            }
        }
        int m = max;
        for (int i = 1; i < s.length() - k + 1; i++) {
            if (maa(chars[i - 1])) {
                m--;
            }
            if (maa(chars[i + k - 1])) {
                m++;
            }
            max = Math.max(max, m);
        }
        return max;
    }

    public boolean maa(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        }
        return false;
    }

    public int get(String s) {
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ss = chars[i];
            if (ss == 'a' || ss == 'e' || ss == 'i' || ss == 'o' || ss == 'u') {
                num++;
            }
        }
        return num;
    }
}
