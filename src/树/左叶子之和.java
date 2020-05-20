package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/6 22:49
 */
public class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        get(root);
        return all;
    }

    int all;

    public int get(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = get(root.left);
        get(root.right);
        if (left != 0) {
            all = all + left;
        }
        return 0;
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
