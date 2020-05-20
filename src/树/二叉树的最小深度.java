package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/1 22:57
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return get(root, 1);
    }

    public int get(TreeNode treeNode, int cen) {
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null) {
                return cen;
            }
            int left = get(treeNode.left, cen + 1);
            int right = get(treeNode.right, cen + 1);
            return left < right ? left : right;
        }
        return Integer.MAX_VALUE;
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
