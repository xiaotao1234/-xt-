package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/10 0:25
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode = new TreeNode(0);
        get(root, p, q, treeNode);
        return treeNode.left;
    }

    public int get(TreeNode treeNode, TreeNode treeNode1, TreeNode treeNode2, TreeNode treeNode3) {
        if (treeNode == null) {
            return 0;
        }
        int left = get(treeNode.left, treeNode1, treeNode2, treeNode3);
        int right = get(treeNode.right, treeNode1, treeNode2, treeNode3);
        if (treeNode1 == treeNode || treeNode2 == treeNode) {
            left = left + right + 1;
        } else {
            left = left + right;
        }
        if (left == 2) {
            treeNode3.left = treeNode;
            return 0;
        }
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
