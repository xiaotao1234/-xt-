package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/6 0:08
 */
public class 二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return get(root, L, R, 0);
    }

    public int get(TreeNode treeNode, int left, int right, int all) {
        if (treeNode == null) {
            return all;
        }
        if (treeNode.val < left) {
            all = get(treeNode.right, left, right, all);
        } else if (treeNode.val > right) {
            all = get(treeNode.left, left, right, all);
        }else {
            all = treeNode.val + all;
            all = get(treeNode.left, left, right, all);
            all = get(treeNode.right, left, right, all);
        }
        return all;
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
