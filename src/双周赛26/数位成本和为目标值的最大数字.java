package 双周赛26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 22:53
 */
public class 数位成本和为目标值的最大数字 {
    public String largestNumber(int[] cost, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (map.containsKey(cost[i])) {
                map.get(cost[i]).add(i + 1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(cost[i], list);
            }
        }
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(0, "");
        for (int i = 0; i < cost.length; i++) {
            int self = cost[i];
            while (self < target) {
                self = self + cost[i];
                map1.put(self, map1.get(self - cost[i]) + (i + 1));
                if (map1.containsKey(target - self)) {
//                    map1.put()
                }
            }
        }
        return "";
    }

    public void get(int[] cost, int end, int target) {
//        for (int i =)
    }
}
