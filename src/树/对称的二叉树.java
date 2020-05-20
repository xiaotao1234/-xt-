package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/7 23:25
 */
public class 对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return get(root.left, root.right);
    }

    public boolean get(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        boolean left = get(treeNode1.left, treeNode2.right);
        boolean right = get(treeNode1.right, treeNode2.left);
        if (treeNode1.val == treeNode2.val && left && right) {
            return true;
        } else {
            return false;
        }
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
