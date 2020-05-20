package 动态规划或贪心;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/6 8:48
 */
public class 最低票价 {

    public static void main(String[] args) {
        最低票价 s = new 最低票价();
        System.out.println(s.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }

    public int mincostTickets(int[] days, int[] costs) {//从后往前进行dp,因为每一个
        int length = days.length, maxDay = days[length - 1], minDay = days[0];
        int[] ints = new int[maxDay + 31];
        for (int d = maxDay, i = length - 1; d >= minDay; d--) {
            if (d == days[i]) {
                ints[d] = Math.min(ints[d + 1] + costs[0], ints[d + 7] + costs[1]);
                ints[d] = Math.min(ints[d], ints[d + 30] + costs[2]);
                i--;
            } else {
                ints[d] = ints[d + 1];
            }
        }
        return ints[minDay];
    }

    public int mincostTickets1(int[] days, int[] costs) {
        int length = days.length;
        int max = days[length - 1];
        int min = days[0];
        int[] dp = new int[max + 31];
        for (int d = max, i = length - 1; d >= min; d--) {
            // 从最大天数开始即需要坐火车的最后一天向逐渐向需要坐火车的第一天开始
            // 需要注意的是这之间有的时间需要坐火车，有的时间不需要坐火车，需要坐火车时，
            // 我们需要找到今天买何种票花费最小，且前提是从现在当天到最后一天，在需要坐火车的时间都能坐上火车
            // 即今天买何种票在满足条件的前提下花费最小，且因为当前买了票，那么根据最小花费的结果构成情况，我们在这之间就无需再买票了
            if (d == days[i]) {
                dp[i] = Math.min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]);
                dp[i] = Math.min(dp[i], dp[i + 30] + costs[2]);
                i--;
            } else {
                dp[i] = dp[i + 1];//若当前天数无需坐火车，那么当前的最小值为下一天的值，
            }
        }
        return dp[min];
    }

//    public int mincostTickets1(int[] days, int[] costs) {
//        int lenght = days.length;
//        int max = days[lenght - 1];
//        int min = days[0];
//        int[] ints = new int[days[days.length - 1] + 31];
//        for (int d = max, i = lenght - 1; d >= min; d--) {
//
//        }
//    }
}
