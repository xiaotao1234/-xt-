package 位运算;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/28 22:47
 */
public class 数组中数字出现的次数 {
    public int[] singleNumbers(int[] nums) {
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};

    }
}
