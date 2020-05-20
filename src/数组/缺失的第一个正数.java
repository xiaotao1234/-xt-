package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/16 23:27
 */
public class 缺失的第一个正数 {

    public static void main(String[] args) {
        缺失的第一个正数 s1 = new 缺失的第一个正数();
        System.out.println(s1.firstMissingPositive(new int[]{1, 2, 0}));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] >= 1 && nums[nums[i] - 1] != nums[i]) {
                int taregt = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = taregt;
            }
        }
        int target = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
