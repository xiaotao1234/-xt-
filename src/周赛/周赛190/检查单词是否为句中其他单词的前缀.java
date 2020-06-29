package 周赛190;

import 树.迭代法的树的先序遍历;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/24 10:30
 */
public class 检查单词是否为句中其他单词的前缀 {

    public static void main(String[] args) {
        检查单词是否为句中其他单词的前缀 s = new 检查单词是否为句中其他单词的前缀();
        s.isPrefixOfWord("hello from the other side"
                , "they");
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.length() == 0) {
            return -1;
        }
        if (searchWord.length() == 0) {
            return 1;
        }

        String[] strings = sentence.split(" ");
        int i = 0;
        for (String s : strings) {i++;
            if(is(s,searchWord)){
                return i;
            }
        }
        return -1;
    }

    public boolean is(String s, String c) {
        for (int i = 0; i < c.length(); i++) {
            if (s.length()-1 < i) {
                return false;
            }
            if (s.charAt(i) != c.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
