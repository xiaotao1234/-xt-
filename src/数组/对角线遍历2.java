package 数组;

import 每日一题.山脉数组中查找目标值;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/29 16:16
 */
public class 对角线遍历2 {

    public static void main(String[] args) {
        对角线遍历2 s = new 对角线遍历2();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(4);
        list3.add(5);
        list3.add(6);
        list3.add(7);
        list4.add(8);
        list5.add(9);
        list5.add(10);
        list5.add(11);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        System.out.println(s.findDiagonalOrder(lists));
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int all = 0;
        for (List<Integer> s : nums) {
            all = all + s.size();
        }
        int index = 0;
        while (list.size() < all) {
            for (int i = index; i >= 0; i--) {
                if (nums.size() > i) {
                    if (nums.get(i).size() > index - i) {
                        list.add(nums.get(i).get(index - i));
                    }
                }
            }
            index++;
        }
        int[] ints = new int[list.size()];
        int i = 0;
        for (int s : list) {
            ints[i] = s;
            i++;
        }
        return ints;
    }

    public int[] findDiagonalOrder1(List<List<Integer>> nums) {
        int len = 0;
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for(int i = 0;i < nums.size();i++) {
            len += nums.get(i).size(); // 获取最后要返回的数组的长度，即元素个数
            for(int j = 0;j < nums.get(i).size();j++) {
                if(map.containsKey(i + j)) {
                    map.get(i + j).add(nums.get(i).get(j));
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i + j, list);
                }
            }
        }
        int[] ans = new int[len];
        int index = 0;
        for(int key : map.keySet()) { // 遍历map
            List<Integer> list = map.get(key);
            for(int j = list.size() - 1;j >= 0;j--) { // 根据题目的输出要求确定生成数组中元素的顺序
                ans[index] = list.get(j);
                index++;
            }
        }
        return ans;
    }

//    作者：zuo-zhou-ren
//    链接：https://leetcode-cn.com/problems/diagonal-traverse-ii/solution/treemapan-dui-jiao-xian-ju-he-zhi-by-zuo-zhou-ren/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
