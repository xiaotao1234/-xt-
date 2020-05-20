package 数组;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/14 11:21
 */
public class 有序数组中出现次数超过25的元素 {
    public int findSpecialInteger(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < (length - length / 4); i++) {
            if (arr[i] == arr[i + length / 4]) {
                return arr[i];
            }
        }
        return 0;
    }
}
