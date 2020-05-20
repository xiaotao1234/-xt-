package 各种排序方法;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 20:31
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        数组中的第K个最大元素 s = new 数组中的第K个最大元素();
        System.out.println(s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest1(int[] nums, int k) {//小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for(int num:nums){
            priorityQueue.offer(num);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        sort(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void sort(int[] nums, int k, int left, int right) {
        if (left > right) {
            return;
        }
        int target = nums[left];
        int sl = left;
        int sr = right;
        while (sl < sr) {
            while (nums[sr] >= target && sl < sr) {
                sr--;
            }
            while (nums[sl] <= target && sl < sr) {
                sl++;
            }
            if (sl < sr) {
                int tmp = nums[sl];
                nums[sl] = nums[sr];
                nums[sr] = tmp;
            }
        }
        int length = nums.length;
        nums[left] = nums[sl];
        nums[sl] = target;
        if ((length - sl) + 1 < k) {
            sort(nums, k, left - k, sl - 1);
            sort(nums, k, sl + 1, right);
        } else {
            sort(nums, k, length - k, right);
        }
    }
}
