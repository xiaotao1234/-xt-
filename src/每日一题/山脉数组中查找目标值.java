package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/29 15:18
 */
public class 山脉数组中查找目标值 {

    public static void main(String[] args) {
        山脉数组中查找目标值 s = new 山脉数组中查找目标值();
        System.out.println(s.findInMountainArray(3, new s()));
    }

    static class s implements MountainArray {
        int[] ints = new int[]{1, 2, 3, 5, 3};

        @Override
        public int get(int index) {
            return ints[index];
        }

        @Override
        public int length() {
            return ints.length;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length();
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid + 1 < mountainArr.length() && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int find = get(target, mountainArr, 0, left, true);
        if (find != -1) {
            return find;
        }
        find = get(target, mountainArr, left, mountainArr.length(), false);
        return find;
    }

    public int get(int target, MountainArray mountainArray, int start, int end, boolean up) {
        int mid = -1;
        while (start < end) {
            mid = start + (end - start) / 2;
            int s = mountainArray.get(mid);
            if (s == target) {
                return mid;
            } else if (s < target) {
                if (up)
                    start = mid + 1;
                else
                    end = mid;
            } else {
                if (up)
                    end = mid;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }


    ///////////////////////////////////
    public int findInMountainArray1(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        //找到i
        int i = binarySearchTop(mountainArr, 0, n);
        //二分查找
        int res1 = binarySearch1(mountainArr, 0, i + 1, target);
        int res2 = binarySearch2(mountainArr, i + 1, n, target);
        return res1 == -1 ? res2 : res1;
    }

    private int binarySearchTop(MountainArray mountainArr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < mountainArr.length() && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                return binarySearchTop(mountainArr, mid + 1, right);
            } else {
                return binarySearchTop(mountainArr, left, mid);
            }
        }
        return left;
    }

    private int binarySearch1(MountainArray mountainArr, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                return binarySearch1(mountainArr, left, mid, target);
            } else {
                return binarySearch1(mountainArr, mid + 1, right, target);
            }
        }
        return -1;
    }

    private int binarySearch2(MountainArray mountainArr, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                return binarySearch2(mountainArr, mid + 1, right, target);
            } else {
                return binarySearch2(mountainArr, left, mid, target);
            }
        }
        return -1;
    }
    ////////////////////////////

    interface MountainArray {
        public int get(int index);

        public int length();
    }
}
