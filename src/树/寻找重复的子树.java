package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/9 21:58
 */
public class 寻找重复的子树 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        get(root, map, list);
        return list;
    }

    public void get(TreeNode treeNode, Map<Integer, List<TreeNode>> map, List<TreeNode> list) {
        if (treeNode == null) {
            return;
        }
        boolean find = false;
        if (map.containsKey(treeNode.val)) {
            List<TreeNode> list1 = map.get(treeNode.val);
            int length = list1.size();
            for (int i = 0; i < list1.size(); i++) {
                TreeNode treeNode1 = list1.get(i);
                if (isSame(treeNode1, treeNode)) {
                    boolean isfind = false;
                    for (TreeNode treeNode2 : list) {
                        if (isSame(treeNode, treeNode2)) {
                            isfind = true;
                        }
                    }
                    if (!isfind) {
                        list.add(treeNode);
                    }
                    map.get(treeNode.val).remove(treeNode1);
                    i--;
                    find = true;
                }
            }
        }
        if (!find) {
            if (map.containsKey(treeNode.val)) {
                map.get(treeNode.val).add(treeNode);
            } else {
                List<TreeNode> treeNodes = new ArrayList<>();
                treeNodes.add(treeNode);
                map.put(treeNode.val, treeNodes);
            }
        }
        get(treeNode.left, map, list);
        get(treeNode.right, map, list);
    }

    public boolean isSame(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        boolean left = isSame(treeNode1.left, treeNode2.left);
        boolean right = isSame(treeNode1.right, treeNode2.right);
        if (!left || !right) {
            return false;
        }
        return true;
    }

    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {//依靠@link node.val+"#"+node.val的形式来唯一的表示一个树，且利用了字符串便于快速判断的特点
        //
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)//当且仅当有两个时加到保存数组中
            ans.add(node);
        return serial;
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
