package 每日一题;

import 周赛186.可获得的最大点数;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/27 13:18
 * 已知小猪每晚都要约好几个女生到酒店房间。每个女生 i 与小猪约好的时间由 [si , ei］表示，其中 si 表示女生进入房间的时间， ei 表示女生离开房间的时间。
 * 由于小猪心胸开阔，思想开明，不同女生可以同时存在于小猪的房间。请计算出小猪最多同时在做几人的「多人运动」。
 * 例子：
 * Input ： [[ 0 , 30] ,[ 5 , 10 ] ， [15 , 20 ] ]
 * OutPut ：最多同时有两个女生的「三人运动」
 */
public class 多人运动 {//https://github.com/azl397985856/leetcode/issues/347#issuecomment-619723641?tdsourcetag=s_pctim_aiomsg
//题解

    public static void main(String[] args) {
        多人运动 s = new 多人运动();
        System.out.println(s.doSomething(new int[][]{{0,30},{5,10},{15,20}}));
    }

    public int doSomething(int[][] nums) {
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                return 0;
            } else {
                return -1;
            }
        });
        int max = Integer.MIN_VALUE;
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(nums[0][0], nums[0][1]));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] < queue.peek().end) {
                queue.add(new node(nums[i][0], nums[i][1]));
                max = Math.max(max, queue.size());
            } else {
                queue.poll();
                i--;
            }
        }
        return max;
    }

    class node {
        int start;
        int end;

        public node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
