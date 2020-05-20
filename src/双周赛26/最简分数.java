package 双周赛26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 22:34
 */
public class 最简分数 {

    public static void main(String[] args) {
        最简分数 s = new 最简分数();
        System.out.println(s.simplifiedFractions(4));
//        System.out.println(s.gcd(3,4));
    }

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            return list;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    list.add(i + "/" + j);
                }
            }
        }
        return list;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
