package 各种排序方法;

/**
 * Created by Xiao Tao on 2020/3/4 11:49
 */
public class 插入排序 {

    public static void main(String[] args) {
        插入排序 s = new 插入排序();
        s.sort1(new int[]{2, 4, 7, 5, 1});
    }

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int s = nums[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && s < nums[j - 1]) {
                        nums[j] = nums[j - 1];
                    } else {
                        nums[j] = s;
                        break;
                    }
                }
            }
        }
        return;
    }

    public void sort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int tmp = nums[i];
                for (int j = i; i >= 0; j--) {
                    if (j > 0 && tmp <= nums[j - 1]) {//当前一位数大于比较数时，将前一位数后移，
                        // 因为明显现在比较数会插入到前一位数前面，会让前一位数的序号增大
                        nums[j] = nums[j - 1];
                    } else {
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
        return;
    }
}
