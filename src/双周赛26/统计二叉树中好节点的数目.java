package 双周赛26;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/16 22:44
 */
public class 统计二叉树中好节点的数目 {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        get(root.left, root.val);
        get(root.right, root.val);
        return num;
    }

    int num = 1;

    public void get(TreeNode treeNode, int max) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val >= max) {
            num++;
        }
        max = Math.max(max, treeNode.val);
        get(treeNode.left, max);
        get(treeNode.right, max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
