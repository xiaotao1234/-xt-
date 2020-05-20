package 栈;

import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/24 23:21
 * 在你的面前从左到右摆放着n根长短不一的木棍，你每次可以折断一根木棍，并将折断后得到的两根木棍一左一右放在原
 * 来的位置（即若原木棍有左邻居，则两根新木棍必须放在左邻居的右边，若原木棍有右邻居，新木棍必须放在右邻居的
 * 左边，所有木棍保持左右排列）。折断后的两根木棍的长度必须为整数，且它们之和等于折断前的木棍长度。你希望最
 * 终从左到右的木棍长度单调不减，那么你需要折断多少次呢？
 *
 * 作者：Ikaruga
 * 链接：https://leetcode-cn.com/circle/discuss/eXOcnD/view/SecVmv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 折木棍 {

    public static void main(String[] args) {
        折木棍 s = new 折木棍();
        System.out.println(s.breakNum(new int[]{3, 13, 12, 9, 12}));
    }

    public int breakNum(int[] nums) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.empty() && stack.peek() < nums[i]) {
                int t = (nums[i] - 1) / stack.peek();
                ans = ans + t;
                stack.push(nums[i] / (t + 1));
                continue;
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
