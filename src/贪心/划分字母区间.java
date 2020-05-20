package 贪心;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/10 22:58
 */
public class 划分字母区间 {

    public static void main(String[] args) {
        划分字母区间 s = new 划分字母区间();
        System.out.println(s.partitionLabels1("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap();//找到元素最后出现的位置
        Set<Integer> list = new HashSet<>();//所有加入的栅栏
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                for (int i1 = map.get(S.charAt(i)) + 1; i1 < i; i1++) {
                    if (list.contains(i1)) {//若当前元素开始与当前来说结束的出现范围内有栅栏
                        list.remove(i1);//将栅栏取消
                    }
                }
            } else {//当前元素，以前未出现过
                map.put(S.charAt(i), i);//设置当前位置为当前元素最先出现的位置
                list.add(i);//因为当前元素之前未出现过，那么这里为可能的栅栏位置，后面出现的在栅栏之前出现过的元素会将这个范围内的栅栏清除掉
            }
        }
        int left = 0;
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= S.length(); i++) {
            if (list.contains(i)) {
                list1.add(i - left);
                left = i;
            }
        }
        list1.add(S.length() - 1 - left + 1);
        return list1;
    }


    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;//收集每个出现的字符最后出现的位置序号

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);//找到目前便利的段中元素出现位置的最大位置序号，及最晚出现的字符
            if (i == j) {//若当前序号和此段内所有元素最后出现的序号相等，代表这段内的元素，没有再在这之后出现过
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
