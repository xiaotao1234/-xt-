package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/5 23:45
 */
public class 二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        int min = root.val;
        return get(root,min);
    }

    public int get(TreeNode treeNode, int min) {
        if (treeNode == null)
            return -1;
        if (treeNode.val > min) {
            return treeNode.val;
        }
        int left = get(treeNode.left, min);
        int right = get(treeNode.right, min);
        if (left > min) {
            if (right > min) {
                return left > right ? right : left;
            }
            return left;
        } else {
            if (right > min) {
                return right;
            } else {
                return -1;
            }
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
