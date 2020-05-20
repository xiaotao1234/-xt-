package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/16 10:15
 */
public class 二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        List<Double> list = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            double all = 0;
            int l = treeNodes.size();
            for (int i = 0; i < l; i++) {
                TreeNode treeNode = treeNodes.remove(0);
                all = all + treeNode.val;
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }
            list.add(all / l);
        }
        return list;
    }


    public void get(TreeNode treeNode, int cen, List<List<Double>> list) {
        if (treeNode == null) {
            return;
        }
        if (list.size() < cen) {
            list.add(cen - 1, new ArrayList<>());
            list.get(cen-1).add((double) treeNode.val);
        } else {
            list.get(cen-1).add(Double.valueOf(treeNode.val));
        }
        get(treeNode.left, cen + 1, list);
        get(treeNode.right, cen + 1, list);
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
