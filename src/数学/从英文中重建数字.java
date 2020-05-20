package 数学;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xt
 * @version 1.0
 * @date 2020/4/13 15:54
 */
public class 从英文中重建数字 {
    public String originalDigits(String s) {
        int[] integers = new int[26];
        for (int i = 0; i < s.length(); i++) {
            integers[s.charAt(i) - 97]++;
        }
        String[] s1 = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < s1[i].length(); j++) {
                list.add(s1[i].charAt(j) - 97);
            }
            lists.add(list);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        for (int i = 0; i < 10; i++) {
            boolean flag = true;
            while (flag) {
                List<Integer> list = lists.get(i);
                for (int j : list) {
                    if (integers[j] <= 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    for (int j : list) {
                        integers[j]--;
                    }
                    list1.add(i);
                }
            }
        }
        String s2 = "";
        for (int m : list1) {
            s2 = s2+m;
        }
        return s2;
    }
}
