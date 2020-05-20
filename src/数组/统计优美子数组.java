package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/21 18:06
 */
public class 统计优美子数组 {

    public static void main(String[] args) {
        统计优美子数组 s1 = new 统计优美子数组();
        System.out.println(s1.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int find = 0;
        int all = 0;
        while (right < nums.length) {
            if (nums[right++] % 2 == 1) {
                find++;
            }
            if (find == k) {
                int tmp = right;
                while (right < nums.length && nums[right] % 2 == 0) {
                    right++;
                }
                tmp = right - tmp;
                int l = 0;
                while (nums[left] % 2 == 0) {
                    l++;
                    left++;
                }
                all = all + (tmp + 1) * (l + 1);
                left++;
                find--;
            }
        }
        return all;
    }
}
