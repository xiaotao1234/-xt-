package 字符串;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/18 22:39
 */
public class 至少有K个重复字符的最长子串 {

    public static void main(String[] args) {
        至少有K个重复字符的最长子串 s = new 至少有K个重复字符的最长子串();
        System.out.println(s.longestSubstring("ababacb",3));
    }

    public int longestSubstring(String s, int k) {
        int length = s.length();
        if (length < k) {
            return 0;
        }
        if (k < 2) {
            return length;
        }
        return get1(s.toCharArray(), k, 0, length - 1);
    }

    public int get1(char[] chars, int k, int start, int end) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] ints = new int[26];
        for (int i = start; i <= end; i++) {
            ++ints[chars[i] - 'a'];
        }
        while (end - start + 1 >= k && ints[chars[start] - 'a'] < k) {
            ++start;
        }
        while (end - start + 1 >= k && ints[chars[end] - 'a'] < k) {
            --end;
        }
        if (end - start + 1 < k) {
            return 0;
        }
        for (int i = start; i <= end; i++) {
            if (ints[chars[i] - 'a'] < k) {
                return Math.max(get1(chars, k, start, i - 1), get1(chars, k, i + 1, end));
            }
        }
        return end - start + 1;
    }

    int max = 0;

    public void get(String s, int k, int start, int end) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Character> set = new HashSet<>();
        for (Character c : map.keySet()) {
            if (map.get(c) < k) {
                set.add(c);
            }
        }
        if (set.size() == 0) {
            max = Math.max(max, end - start + 1);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char ss = s.charAt(i);
                if (set.contains(ss)) {
                    list.add(i);
                }
            }
        }
    }
}
