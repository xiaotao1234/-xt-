package 字符串;

import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/1 22:33
 */
public class 反转字符串中的单词3 {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    s1 = s1.append(stack.pop());
                }
                s1 = s1.append(" ");
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            s1 = s1.append(stack.pop());
        }
        return String.valueOf(s1);
    }
}
