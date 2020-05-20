package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/5 7:55
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return get(root, null, null);
    }

    public boolean get(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        }
        if (left != null && root.val <= left) return false;
        if (right != null && root.val >= right) return false;
        if (!get(root.left, left, root.val)) return false;
        if (!get(root.right, root.val, right)) return false;
        return true;
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
