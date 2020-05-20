package 贪心;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/11 8:11
 */
public class 安排电影院座位 {

    public static void main(String[] args) {
        安排电影院座位 s = new 安排电影院座位();
        System.out.println(s.maxNumberOfFamilies(2, new int[][]{{2, 1}, {1, 8}, {2, 6}}));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            if (map.containsKey(reservedSeats[i][0])) {
                map.get(reservedSeats[i][0]).add(reservedSeats[i][1]-1);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(reservedSeats[i][1]-1);
                map.put(reservedSeats[i][0], list);
            }
        }
        int all = 0;
        for (int i = 0; i < n; i++) {
            all = all + get(i, map);
        }
        return all;
    }

    public int get(int i, Map<Integer, Set<Integer>> map) {
        if (!map.containsKey(i + 1)) {
            return 2;
        }
        Set<Integer> set;
        set = map.get(i + 1);
        int all = 0;
        if (!set.contains(1) && !set.contains(2) && !set.contains(3) && !set.contains(4)) {
            all++;
        }
        if (all == 1) {
            if (!set.contains(5) && !set.contains(6) && !set.contains(7) && !set.contains(8)) {
                all++;
            }
        } else {
            if (!set.contains(3) && !set.contains(4) && !set.contains(5) && !set.contains(6)) {
                all++;
            } else if (!set.contains(5) && !set.contains(6) && !set.contains(7) && !set.contains(8)) {
                all++;
            }
        }
        return all;
    }
}
