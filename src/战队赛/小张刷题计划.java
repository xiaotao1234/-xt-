package 战队赛;

import 动态规划或贪心.三步问题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/25 15:00
 */
public class 小张刷题计划 {

    public static void main(String[] args) {
        小张刷题计划 s = new 小张刷题计划();
        s.minTime(new int[]{1, 2, 10, 9, 8, 7, 6, 5, 9, 10}, 5);
    }

    public int minTime(int[] time, int m) {
        if (time.length <= m) {
            return 0;
        }
        int[][][] dp = new int[m][time.length][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < time.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j][0] = 0;//0代表当前寻求了帮助
                    dp[i][j][1] = time[0];
                } else if (i == 0) {
                    dp[i][j][0] = Math.min(dp[i][j - 1][0] + time[j], dp[i][j - 1][1]);
                    dp[i][j][1] = dp[i][j - 1][1] + time[j];
                } else if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], time[j]);
                } else {
//                    dp[i][j][0] = Math.min(dp[i][j - 1][0] + time[j], Math.min(dp[i][j - 1][1], dp[i - 1][j - 1][0]));
                    if (Math.min(dp[i][j - 1][0] + time[j], dp[i][j - 1][1]) > dp[i - 1][j - 1][0]) {
                        dp[i][j][0] = dp[i - 1][j - 1][0];
                    } else {
                        dp[i][j][0] = Math.min(dp[i][j - 1][0] + time[j], dp[i][j - 1][1]);
                    }
//                    dp[i][j][1] = Math.min(dp[i][j - 1][1] + time[j], dp[i - 1][j][0]);
                    if ((dp[i][j - 1][1] + time[j]) > dp[i - 1][j][0]) {
                        dp[i][j][1] = dp[i - 1][j][0];
                    } else {
                        dp[i][j][1] = dp[i][j - 1][1] + time[j];
                    }
                }
            }
        }
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.max(min, dp[i][time.length - 1][0]);
        }
        return min;
    }

    public int minTime1(int[] time, int m) {
        int n = time.length;
        if(n <= m) return 0;
        int sum = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left < right){
            int mid = (left+right)/2;
            if(isOk(time, mid, m)) right = mid;
            else left = mid+1;
        }
        return left;
    }
    public boolean isOk(int[] time, int k, int m){//对当前预判的单天时间的最大值做合理性判断，若返回为true，则代表当前的值可能偏大
        //否则可能偏小，然后去逐渐逼近，直到最终夹逼出刚好能满足条件的值。这个值就是最小的单天最大值
        int max = 0;
        int sum = 0;
        int n = time.length;
        for(int i = 0; i < n; i++){
            if(m == 0) return false;
            if(max < time[i]) max = time[i];
            sum += time[i];
            if(sum - max > k){
                i--;
                max = 0;
                m--;
                sum = 0;
            }
        }
        return true;
    }

//    作者：aqianglab
//    链接：https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/solution/er-fen-fa-cha-zhao-zui-xiao-neng-tong-guo-de-tian-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
