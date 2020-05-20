package 字符串;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 23:26
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "%20" + s.substring(i + 1);
                i = i + 2;
            }
            i++;
        }
        return s;
    }
}
