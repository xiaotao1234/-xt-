package 分治;

import java.util.PriorityQueue;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/29 21:05
 */
public class 最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int num : arr) {
            heap.offer(num);
        }
        int[] res = new int[k];
        int j = 0;
        while (j < k) {
            res[j++] = heap.poll();
        }
        return res;
    }
}
