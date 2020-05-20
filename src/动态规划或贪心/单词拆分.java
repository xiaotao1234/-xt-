package 动态规划或贪心;

import java.util.*;

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//说明：
//
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-break
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 单词拆分 {
    public static void main(String[] args) {
        单词拆分 s = new 单词拆分();
        List<String> strings = new ArrayList<>();
        strings.add("code");
        strings.add("leet");
        System.out.println(s.wordBreak1("leetcode", strings));
    }

    public boolean wordBreak(String s, List<String> wordDict) {//对给定的需要判断的字符串进行暴力的全便利，加入了记忆来优化时间复杂度
        Set<String> stringSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && stringSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {//在前面满足的基础上，对每个字典里面的词汇进行s下一段的存在性判断，
        // 对存在的进行截取后，后段继续向下走来判断剩下的，直到判断到末尾，代表能全被字典中的词切分
        return get(s, 0, wordDict);
    }

    Map<Integer, Boolean> map = new HashMap<>();

    public boolean get(String s, int off, List<String> wordList) {
        if (off == s.length()) {
            return true;
        }
        if (map.containsKey(off)) {
            return map.get(off);
        }
        for (String s1 : wordList) {
            if (s.substring(off, Math.min(s.length(), off + s1.length())) .equals(s1)) {
                if (get(s, off + s1.length(), wordList)) {
                    map.put(off,true);
                    return true;
                }
            }
        }
        map.put(off,false);
        return false;
    }
}
