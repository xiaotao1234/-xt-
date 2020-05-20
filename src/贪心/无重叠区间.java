package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/12 8:45
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        无重叠区间 s = new 无重叠区间();
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int ans = 1;
        int[] dp = new int[intervals.length];//dp[i]i元素之前的最大长度
        dp[0] = 1;
        for (int i = 1; i < intervals.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i][0] >= intervals[j][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int all = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                all++;
                end = intervals[i][1];
            }
        }
        return intervals.length - all;
    }

//    public class Solution {
//        class myComparator implements Comparator<Interval> {
//            public int compare(Interval a, Interval b) {
//                return a.start - b.start;
//            }
//        }
//
//        public int eraseOverlapIntervals(Interval[] intervals) {
//            Arrays.sort(intervals, new myComparator());
//            return erase_Overlap_Intervals(-1, 0, intervals);
//        }
//
//        public int erase_Overlap_Intervals(int prev, int curr, Interval[] intervals) {
//            if (curr == intervals.length) {
//                return 0;
//            }
//            int taken = Integer.MAX_VALUE, nottaken;
//            if (prev == -1 || intervals[prev].end <= intervals[curr].start) {
//                taken = erase_Overlap_Intervals(curr, curr + 1, intervals);
//            }
//            nottaken = erase_Overlap_Intervals(prev, curr + 1, intervals) + 1;
//            return Math.min(taken, nottaken);
//        }
//    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
