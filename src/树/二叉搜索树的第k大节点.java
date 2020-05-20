package 树;

import 动态规划或贪心.零钱兑换;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/13 23:47
 */
public class 二叉搜索树的第k大节点 {

    public static void main(String[] args) {
//        二叉搜索树的第k大节点 s = new 零二叉搜索树的第k大节点钱兑换();
//        System.out.println(s.kthLargest(new int[]{3}, 9));
    }

    public int kthLargest(TreeNode root, int k) {
        get(root, k, 0);
        return m;
    }

    int m;

    public int get(TreeNode treeNode, int k, int now) {
        if (treeNode == null) {
            return now;
        }
        int right = get(treeNode.right, k, now);
        if (right + 1 == k) {
            m = treeNode.val;
        }
        int left = get(treeNode.left, k, right + 1);
        return left;
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
