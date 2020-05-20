package 贪心;

import 各种排序方法.冒泡排序;

import java.util.Arrays;

public class 分发糖果 {
    public static void main(String[] args) {
        分发糖果 s = new 分发糖果();
        System.out.println(s.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }

    public int candy(int[] ratings) {
        int[] get = new int[ratings.length];
        Arrays.fill(get, 1);
        for (int i = 0; i < ratings.length; i++) {
            int q = i - 1;
            int h = i + 1;
            if (q >= 0) {
                if (ratings[i] > ratings[q]) {
                    get[i] = get[i - 1] + 1;
                }
            }
            if (h < ratings.length) {
                if (ratings[i] > ratings[h]) {
                    get[i] = get[i + 1] + 1;
                }
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            int q = i - 1;
            int h = i + 1;
            if (q >= 0) {
                if (ratings[i] > ratings[q] && get[q] >= get[i]) {
                    get[i] = get[i - 1] + 1;
                }
            }
            if (h < ratings.length) {
                if (ratings[i] > ratings[h]&& get[h] >= get[i]) {
                    get[i] = get[i + 1] + 1;
                }
            }
        }
        int all = 0;
        for (int s : get) {
            all = all + s;
        }
        return all;
    }

}
