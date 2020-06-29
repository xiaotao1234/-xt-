package 周赛184;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/12 10:49
 */
public class 查询带键的排列 {
    public static void main(String[] args) {
        查询带键的排列 s = new 查询带键的排列();
        System.out.println(s.processQueries(new int[]{7,5,5,8,3}, 8));
    }

    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = find(queries[i], list);
            list1.add(index);
            list.add(0, list.get(index));
            list.remove(index + 1);
        }
        int[] s = new int[list1.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = list1.get(i);
        }
        return s;
    }

    public int find(int num, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (num == list.get(i)) {
                return i;
            }
        }
        return 0;
    }
}
