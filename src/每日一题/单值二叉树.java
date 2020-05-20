package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 22:22
 */
public class 单值二叉树 {


    public boolean get(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = get(root.left);
        boolean right = get(root.right);
        if (left && right && (root.left == null || root.left.val == root.val) &&
                (root.right == null || root.right.val == root.val)) {
            return true;
        }
        return false;
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
