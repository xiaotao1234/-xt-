package 周赛185;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/19 10:43
 */
public class 数青蛙 {

    public static void main(String[] args) {
        数青蛙 s = new 数青蛙();
        System.out.println(s.minNumberOfFrogs("croakcroa"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        List<Integer> c = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        List<Integer> o = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        char[] chars = croakOfFrogs.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'c') {
                c.add(i);
            } else if (chars[i] == 'r') {
                r.add(i);
            } else if (chars[i] == 'o') {
                o.add(i);
            } else if (chars[i] == 'a') {
                a.add(i);
            } else {
                k.add(i);
            }
        }
        int szie = c.size();
        if (szie != r.size() || o.size() != szie || a.size() != szie || k.size() != szie) {
            return -1;
        }
        int csize = c.size();
        int rsize = c.size();
        int osize = c.size();
        int asize = c.size();
        int ksize = c.size();
        int[] cnow = new int[5];
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (csize != 0 && rsize != 0 && osize != 0 && asize != 0 && ksize != 0) {
            if (chars[i] == 'c') {
                cnow[0]++;
                csize--;
            } else if (chars[i] == 'r') {
                cnow[1]++;
                rsize--;
            } else if (chars[i] == 'o') {
                cnow[2]++;
                osize--;
            } else if (chars[i] == 'a') {
                cnow[3]++;
                asize--;
            } else {
                cnow[4]++;
                ksize--;
            }
            i++;
            int target = cnow[0];
            for (int j = 1; j < 5; j++) {
                if (cnow[j] > target) {
                    return -1;
                }
                target = cnow[j];
            }
            int min = cnow[4];
            for (int j = 0; j < 5; j++) {
                cnow[j] = cnow[j] - min;
            }
            max = Math.max(max, cnow[0]);
        }
        return max;
    }
}
