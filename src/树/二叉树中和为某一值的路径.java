package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/19 21:14
 */
public class 二叉树中和为某一值的路径 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        get(root, sum, root.val, list);
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    public void get(TreeNode treeNode, int sum, int now, List<Integer> list) {
        if (treeNode.left == null && treeNode.right == null) {
            if (sum == now)
                lists.add(new ArrayList<>(list));
            return;
        }
        if (treeNode.left != null) {
            list.add(treeNode.left.val);
            get(treeNode.left, sum, now + treeNode.left.val, list);
            list.remove(list.size() - 1);
        }
        if (treeNode.right != null) {
            list.add(treeNode.right.val);
            get(treeNode.right, sum, now + treeNode.right.val, list);
            list.remove(list.size() - 1);
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
