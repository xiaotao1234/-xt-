package 双周赛25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/2 22:59
 */
public class 改变一个整数能得到的最大差值 {

    public static void main(String[] args) {
        改变一个整数能得到的最大差值 s = new 改变一个整数能得到的最大差值();
        System.out.println(s.maxDiff(9288));
    }

    public int maxDiff(int num) {
        int heigh = 0, low = 0;
        int height = -1, lowe = -1;
        int s = num;
        List<Integer> list = new ArrayList<>();
        while (s != 0) {
            list.add(s % 10);
            s = s / 10;
        }
        boolean flag = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != 9 && !flag) {
                flag = true;
                heigh = heigh * 10 + 9;
                height = list.get(i);
            } else if (list.get(i) == height) {
                heigh = heigh * 10 + 9;
            } else {
                heigh = heigh * 10 + list.get(i);
            }
        }
        boolean flag1 = false;
        int m = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == list.size() - 1 && list.get(i) != 1) {
                lowe = list.get(i);
                low = low * 10 + 1;
                m = 1;
                flag1 = true;
            } else if (flag1) {
                if (list.get(i) == lowe) {
                    low = low * 10 + m;
                } else {
                    low = low * 10 + list.get(i);
                }
            } else {
                if (i == list.size() - 1) {
                    low = 1;
                } else {
                    if (list.get(i) != list.get(list.size() - 1)) {
                        flag1 = true;
                        m = 0;
                        lowe = list.get(i);
                        low = low * 10;
                    } else {
                        low = low;
                    }
                }
            }
        }
        return heigh - low;
    }

    public int maxDiff1(int num) {
        String s1 = String.valueOf(num);
        String s2 = s1;
        int i = 0, j = 0;
        while (i < s1.length() && s1.charAt(i) == '9') {
            i++;
        }
        if (i != s1.length()) {
            s1 = s1.replace(s1.charAt(i), '9');
        }
        if (s2.charAt(0) == '1') {
            while (j < s2.length() && (s2.charAt(j) == '1' || s2.charAt(j) == '0')) {
                j++;
            }
        }
        if (j != s2.length()) {
            if (j != 0) {
                s2 = s2.replace(s2.charAt(j), '0');
            } else {
                s2 = s2.replace(s2.charAt(j), '1');
            }
        }
        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }

    public int maxDiff2(int num) {
        String s = String.valueOf(num);
        String s1 = s;
        int i = 0, j = 0;
        while (i < s.length() && s.charAt(i) == '9') {
            i++;
        }
        if (i != s.length()) {
            s = s.replace(s.charAt(i), '9');
        }
        if (s1.charAt(0) == '1') {
            while (j < s1.length() && (s1.charAt(j) == '1' || s1.charAt(j) == '0')) {
                j++;
            }
        }
        if (j != s1.length()) {
            if (j != 0) {
                s1 = s1.replace(s1.charAt(j), '0');
            } else {
                s1 = s1.replace(s1.charAt(j), '1');
            }
        }
        return Integer.parseInt(s) - Integer.parseInt(s1);
    }
}
