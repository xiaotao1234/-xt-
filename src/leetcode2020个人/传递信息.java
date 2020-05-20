package leetcode2020个人;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 15:03
 */
public class 传递信息 {

    public static void main(String[] args) {
        传递信息 s = new 传递信息();
        System.out.println(s.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3));
    }
    public int numWays(int n, int[][] relation, int k) {
        get(n, relation, k, 0, 0);
        return all;
    }

    int all = 0;

    public void get(int n, int[][] relation, int k, int i, int nowpeople) {
        if (i == k) {
            if (nowpeople == n-1) {
                all = all + 1;
            }
            return;
        } else {
            for (int[] ints : relation) {
                if (ints[0] == nowpeople) {
                    get(n, relation, k, i + 1, ints[1]);
                }
            }
        }
    }
}
