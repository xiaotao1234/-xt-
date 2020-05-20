package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/22 9:24
 */
public class 二叉树的右视图 {
    public List<Integer> rightSideView1(TreeNode root) {
        List<TreeNode> list3 = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        list3.add(root);
        get(list3);
        return lists;
    }

    List<Integer> lists = new ArrayList<>();

    public void get(List<TreeNode> list) {//层序遍历
        if (list.size() == 0) {
            return;
        }
        List<TreeNode> list1 = new ArrayList<>();
        lists.add(list.get(list.size() - 1).val);
        for (TreeNode treeNode : list) {
            if (treeNode.left != null)
                list1.add(treeNode.left);
            if (treeNode.right != null)
                list1.add(treeNode.right);
        }
        get(list1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        get(root, 0, list);
        return list;
    }

    public void get(TreeNode treeNode, int deep, List<Integer> lists) {
        if (treeNode == null) {
            return;
        }
        if (lists.size() > deep) {
            lists.set(deep, treeNode.val);
        } else {
            lists.add(treeNode.val);
        }
        get(treeNode.left,deep+1,lists);
        get(treeNode.right,deep+1,lists);
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
