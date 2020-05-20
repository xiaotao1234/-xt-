package 动态规划或贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/24 22:18
 */
public class 分裂二叉树的最大乘积 {
    public int maxProduct(TreeNode root) {
        int s = (int) (1e9 + 7);
        get(root);
        long max = -1;
        for (long l : list) {
            max = Math.max(max, l * (list.get(list.size() - 1) - l));
        }
        if (max >= s) {
            return (int) (max % s);
        }
        return (int) max;
    }

    List<Long> list = new ArrayList<>();

    public long get(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        long left = get(treeNode.left);
        long right = get(treeNode.right);
        long value = left + right + treeNode.val;
        list.add(value);
        return value;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
