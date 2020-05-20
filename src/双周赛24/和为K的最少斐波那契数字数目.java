package 双周赛24;

import 双周赛20.包含所有三种字符的子字符串数目;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 22:36
 */
public class 和为K的最少斐波那契数字数目 {

    public static void main(String[] args) {
        和为K的最少斐波那契数字数目 s = new 和为K的最少斐波那契数字数目();
        System.out.println(s.findMinFibonacciNumbers(28));
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int i = 1;
        list.add(i);
        while (i <= k) {
            list.add(i);
            set.add(i);
            i = list.get(list.size() - 2) + list.get(list.size() - 1);
        }
        int time = 0;
        while (k != 0) {
            while (list.get(list.size() - 1) > k) {
                list.remove(list.size() - 1);
            }
            k = k - list.get(list.size() - 1);
            time++;
        }
        return time;
    }

    public int get(int k, Set<Integer> set, int num) {
        if (k == 0) {
            return num;
        }
        int min = Integer.MAX_VALUE;
        for (int s : set) {
            if (k - s >= 0)
                min = Math.min(get(k - s, set, num + 1), min);
        }
        return min;
    }

}
