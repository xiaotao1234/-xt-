package 周赛188;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/10 10:39
 */
public class 形成两个异或相等数组的三元组数目 {

    public static void main(String[] args) {
        形成两个异或相等数组的三元组数目 s = new 形成两个异或相等数组的三元组数目();
        System.out.println(s.countTriplets(new int[]{7,11,12,9,5,2,7,17,22}));
    }

    public int countTriplets(int[] arr) {
        int length = arr.length;
        int all = 0;
        for (int x = 0; x < length - 1; x++) {
            for (int y = x + 1; y < length; y++) {
                for (int z = y; z < length; z++) {
                    if (get(arr, x, y - 1) == get(arr, y, z)) {
                        all++;
                    }
                }
            }
        }
        return all;
    }

    public int get(int[] arr, int start, int end) {
        int s = arr[start];
        for (int i = start + 1; i <= end; i++) {
            s = s ^ arr[i];
        }
        return s;
    }
}
