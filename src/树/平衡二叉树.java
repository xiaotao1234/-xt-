package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/6 0:01
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if (get(root, 1) == -1) {
            return false;
        }
        return true;
    }

    public int get(TreeNode treeNode, int deep) {
        int left = deep, right = deep;
        if (treeNode.left != null)
            left = get(treeNode.left, deep + 1);
        if (treeNode.right != null)
            right = get(treeNode.right, deep + 1);
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return left > right ? left : right;
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
