package 字符串;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/15 23:52
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n - 1);
    }
}
