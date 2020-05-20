package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/6 22:56
 */
public class 从上到下打印二叉树2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        get(root, 1, lists);
        return lists;
    }

    public void get(TreeNode treeNode, int cen, List<List<Integer>> lists) {
        if (treeNode == null) {
            return;
        }
        if (lists.size() >= cen) {
            lists.get(cen).add(treeNode.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(treeNode.val);
            lists.add(list);
        }
        get(treeNode.left, cen + 1, lists);
        get(treeNode.right, cen + 1, lists);
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
