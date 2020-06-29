package 周赛184;

import 面向对象的demo练习.上下转型;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/12 11:19
 */
public class 给Nx3网格图涂色的方案数 {
    public static void main(String[] args) {
        给Nx3网格图涂色的方案数 s = new 给Nx3网格图涂色的方案数();

        System.out.println(s.numOfWays(5000));
    }

    public int numOfWays(int n) {//红 1 黄 2 绿 3
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 1});
        list.add(new int[]{2, 1, 2});
        list.add(new int[]{3, 1, 2});
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{2, 1, 3});
        list.add(new int[]{3, 1, 3});
        list.add(new int[]{1, 3, 1});
        list.add(new int[]{2, 3, 1});
        list.add(new int[]{3, 2, 1});
        list.add(new int[]{1, 3, 2});
        list.add(new int[]{2, 3, 2});
        list.add(new int[]{3, 2, 3});
        long[] ints = new long[12];
        Arrays.fill(ints, 1);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            lists.add(get(list, i));
        }
        for (int i = 1; i < n; i++) {
            long[] ints1 = new long[12];
            add(ints, lists, ints1);
            ints = ints1;
        }
        long all = 0;
        for (long s : ints) {
            all = all + s;
            if (all > (1000000000 + 7)) {
                all = all % (1000000000 + 7);
            }
        }
        return (int) all;
    }

    public long[] add(long[] ints, List<List<Integer>> lists, long[] ints1) {
        for (int i = 0; i < ints.length; i++) {
            for (int k : lists.get(i)) {
                ints1[k] = ints1[k] + ints[i];
                if (ints1[k] >= (1000000000 + 7)) {
                    ints1[k] = ints1[k] % (1000000000 + 7);
                }
            }
        }
        return ints1;
    }

    public List<Integer> get(List<int[]> list, int i) {
        List<Integer> list1 = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            if (j != i) {
                if (list.get(j)[0] != list.get(i)[0] && list.get(j)[1] != list.get(i)[1] && list.get(j)[2] != list.get(i)[2]) {
                    list1.add(j);
                }
            }
        }
        return list1;
    }
}
