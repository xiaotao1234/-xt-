package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/17 22:09
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        get(n, "", 0, 0);
        return list;
    }

    List<String> list = new ArrayList<>();

    public void get(int n, String s, int left, int right) {
        if (s.length() == n * 2) {
            list.add(new String(s));
            return;
        }
        if (left == right) {
            get(n, s + "(", left + 1, right);
        } else if (left > right) {
            if (left < n) {
                get(n, s + "(", left + 1, right);
            }
            get(n, s + ")", left, right + 1);
        }
    }
}
