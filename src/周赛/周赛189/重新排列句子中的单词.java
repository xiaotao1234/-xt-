package 周赛189;

import 零一背包问题.背包1;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/17 10:34
 */
public class 重新排列句子中的单词 {

    public static void main(String[] args) {
        重新排列句子中的单词 s = new 重新排列句子中的单词();
        System.out.println(s.arrangeWords("Leetcode"));
    }

    public String arrangeWords(String text) {
        int start = 0;
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (map.containsKey(i - start)) {
                    map.get(i - start).add(text.substring(start, i).toLowerCase());
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(text.substring(start, i).toLowerCase());
                    map.put(i - start, list);
                }
                start = i + 1;
            }
        }
        if (map.containsKey(text.length() - start)) {
            map.get(text.length() - start).add(text.substring(start));
        } else {
            List<String> list = new ArrayList<>();
            list.add(text.substring(start));
            map.put(text.length() - start, list);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            list.add(i);
        }
        Collections.sort(list);
        String s = "";
        for (int i : list) {
            List<String> strings = map.get(i);
            for (String s1 : strings) {
                s = s + s1 + " ";
            }
        }
        s = s.substring(0,1).toUpperCase() + s.substring(1);
        s = s.substring(0,s.length()-1);
        return s;
    }
}
