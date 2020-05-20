package leetcode2020个人;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/18 15:17
 */
public class 剧情触发时间 {


    public static void main(String[] args) {
        剧情触发时间 s = new 剧情触发时间();
        System.out.println(s.getTriggerTime(new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}}, new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}}));
    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] ints = new int[requirements.length];
        Arrays.fill(ints, -1);
        Set<Integer> set = new HashSet<>();
        int m1 = 0, m2 = 0, m3 = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
        for (int j = 0; j < ints.length; j++) {
            set.add(j);
            min1 = Math.min(min1, requirements[j][0]);
            min2 = Math.min(min2, requirements[j][1]);
            min3 = Math.min(min3, requirements[j][2]);
        }
        for (int i = 0; i <= increase.length; i++) {//i+1为天数
            if (m1 >= min1 && m2 >= min2 && m3 >= min3) {
                List<Integer> list = new ArrayList<>();
                min1 = Integer.MAX_VALUE;
                min2 = Integer.MAX_VALUE;
                min3 = Integer.MAX_VALUE;
                for (int j : set) {
                    if (m1 >= requirements[j][0] && m2 >= requirements[j][1] && m3 >= requirements[j][2]) {
                        ints[j] = i;
                        list.add(j);
                    }else {
                        min1 = Math.min(min1, requirements[j][0]);
                        min2 = Math.min(min2, requirements[j][1]);
                        min3 = Math.min(min3, requirements[j][2]);
                    }
                }
                for (int l : list) {
                    set.remove(l);
                }
            }
            if (set.size() == 0) {
                break;
            }
            if (i < increase.length) {
                m1 = m1 + increase[i][0];
                m2 = m2 + increase[i][1];
                m3 = m3 + increase[i][2];
            }
        }
        return ints;
    }

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

    public int binarySearch(int[][] data, int[] r, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (check(data[mid], r)) {
            int index = binarySearch(data, r, start, mid - 1);
            if (index != -1) {
                return index;
            } else {
                return mid;
            }
        } else {
            return binarySearch(data, r, mid + 1, end);
        }

    }

    public int[] getTriggerTime2(int[][] increase, int[][] requirements) {
        int n = requirements.length;
        int[] ans = new int[n];
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i<n;++i){
            int[] pre = {requirements[i][0],requirements[i][1],requirements[i][2],i};
            if(requirements[i][0]==0&&requirements[i][1]==0&&requirements[i][2]==0) ans[i] = 0;
            else{
                list.add(pre);
                ans[i] = -1;
            }
        }
        Collections.sort(list, Comparator.comparingInt(a -> a[1]));
        int[] num = new int[3];
        int day = increase.length;

        for(int i = 0;i<day&&!list.isEmpty();++i){
            num[0]+=increase[i][0];
            num[1]+=increase[i][1];
            num[2]+=increase[i][2];
            int j = 0;
            while(j<list.size()){
                int[] pre = list.get(j);
                if(pre[1]>num[1]) break;
                if(pre[0]<=num[0]&&pre[1]<=num[1]&&pre[2]<=num[2]){
                    ans[pre[3]] = i+1;
                    list.remove(j);
                }else ++j;

            }
        }
        return ans;
    }

//    public int[] getTriggerTime1(int[][] increase, int[][] requirements) {
//        node[] nodes = new node[requirements.length];
//        for()
//        int[] ints = new int[requirements.length];
//        Arrays.fill(ints, -1);
//        int m1 = 0, m2 = 0, m3 = 0;
//        for (int j = 0; j < ints.length; j++) {
//            if (m1 >= requirements[j][0] && m2 >= requirements[j][1] && m3 >= requirements[j][2]) {
//                ints[j] = 0;
//            }
//        }
//        for (int i = 0; i < increase.length; i++) {//i+1为天数
//            m1 = m1 + increase[i][0];
//            m2 = m2 + increase[i][1];
//            m3 = m3 + increase[i][2];
//            for (int j = 0; j < ints.length; j++) {
//                if (ints[j] == -1) {
//                    if (m1 >= requirements[j][0] && m2 >= requirements[j][1] && m3 >= requirements[j][2]) {
//                        ints[j] = i + 1;
//                    }
//                }
//            }
//        }
//        return ints;
//    }

    class node {
        int m1, m2, m3;

        public node(int m1, int m2, int m3) {
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
        }

        @Override
        public int hashCode() {
            return m1;
        }

        @Override
        public boolean equals(Object obj) {
            node node1 = (node) obj;
            if (node1.m1 == this.m1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
