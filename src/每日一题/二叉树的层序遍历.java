package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/13 8:16
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        get(lists, root, 0);
        return lists;
    }

    public void get(List<List<Integer>> lists, TreeNode treeNode, int cen) {
        if (treeNode == null) {
            return;
        }
        if (lists.size()-1 >= cen) {
            lists.get(cen).add(treeNode.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(treeNode.val);
            lists.add(list);
        }
        get(lists, treeNode.left, cen + 1);
        get(lists, treeNode.right, cen + 1);
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
