package 动态规划或贪心;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 7:38
 */
public class 单词拆分II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s1 : wordDict) {
            if (map.containsKey(s1.length())) {
                map.get(s1.length()).add(s1);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s1);
                map.put(s1.length(), stringList);
            }
        }
        return new ArrayList<>();
    }

    private Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak1(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }


    private List<String> dfs(String s, List<String> wordDict, int offset) {

        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        if (cache.containsKey(s.substring(offset))) {
            return cache.get(s.substring(offset));
        }

        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                List<String> next = dfs(s, wordDict, offset + word.length());
                for (String str : next) {
                    res.add((word + " " + str).trim());
                }
            }
        }

        cache.put(s.substring(offset), res);
        return res;
    }

    Map<String, List<String>> caches = new HashMap<>();

    public List<String> wordBreak3(String s, List<String> wordDict) {
        return get(s, wordDict, 0);
    }

    public List<String> get(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        if (caches.containsKey(s.substring(offset))) {
            return caches.get(s.substring(offset));
        }
        List<String> stringList = new ArrayList<>();
        for (String s1 : wordDict) {
            if (s1.equals(s.substring(offset, Math.min(offset + s1.length(), s.length())))) {
                List<String> strings = get(s, wordDict, offset + s1.length());
                for (String m : strings) {
                    stringList.add((s1 + " " + m).trim());
                }
            }
        }
        caches.put(s.substring(offset), stringList);
        return stringList;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];

        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;//为子类型为LinkedList<String>的数组添加第一个空元素

        for (int i = 1; i <= s.length(); i++) {//以i为end结束位置的确定。
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {//以i为结束，j为开始的部分进行遍历
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {//如果0，j位置的字符存在可完全构建的子串，且j，i位置的字符也在字典中存在
                    for (String l : dp[j]) {//对0，j存在的可构建子串的每个串添加上j，i的字符后添加到list中，list作为0，i位置（dp[i]）的dp结果进行保存
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));//若0，j为“”，则代表为头部，则不插入“ ”，否者插入一个“ ”来满足插入一个空格隔开的题意要求
                    }
                }
            }
            dp[i] = list;
        }

        return dp[s.length()];
    }
}
