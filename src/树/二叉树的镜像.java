package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/6 22:45
 */
public class 二叉树的镜像 {


    public TreeNode get(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = get(root.left);
        TreeNode right = get(root.right);
        root.left = right;
        root.right = left;
        return root;
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
