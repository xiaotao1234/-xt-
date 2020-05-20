package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/16 0:25
 */
public class 合并区间 {

    public static void main(String[] args) {
        合并区间 s1 = new 合并区间();
        System.out.println(s1.merge(new int[][]{{1, 3}}));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        boolean flag = true;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            while (i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            list.add(new int[]{start, end});
            flag = true;
            if (i < intervals.length) {
                start = intervals[i][0];
                end = intervals[i][1];
                flag = false;
            }
        }
        if (!flag)
            list.add(new int[]{start, end});
        int[][] ints = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ints[i][0] = list.get(i)[0];
            ints[i][1] = list.get(i)[1];
        }
        return ints;
    }
}
