package 二分查找;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 20:44
 */
public class 第2020年赛第三题剧情触发时间 {//使用二分来减少时间复杂度（特殊的二分查找，因为这里找的是第一个满足条件的，而不是精确比对）
    public int[] getTriggerTime1(int[][] increase, int[][] requirements) {
        int n = increase.length;
        int[][] data = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                data[i + 1][j] = data[i][j] + increase[i][j];
            }
        }
        int[] res = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            res[i] = binarySearch(data, requirements[i], 0, data.length - 1);
        }
        return res;
    }

    public boolean check(int[] a, int[] b) {
        return a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2];
    }

    public int binarySearch(int[][] data, int[] r, int start, int end) {//二分
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (check(data[mid], r)) {//
            int index = binarySearch(data, r, start, mid - 1);//关键在于当目前的中点的位置的值满足条件，
            // 但并不代表这就是要查找的位置，因为我们要找的是第一个满足条件的，因此我们继续向左找，这里用递归，递归本函数，若向左找到了，继续向左找
            // 直到左右边界不再满足左右边界left>right时，返回-1，否者返回中点，这样我们就能依靠二分找到第一个满足条件的位置
            if (index != -1) {
                return index;
            } else {
                return mid;
            }
        } else {
            return binarySearch(data, r, mid + 1, end);
        }

    }
}
