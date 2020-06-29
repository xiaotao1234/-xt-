package 周赛190;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/24 11:04
 */
public class 二叉树中的伪回文路径 {

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

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return get(root, map);
    }

    public int get(TreeNode treeNode, Map<Integer, Integer> map) {
        if (treeNode.left == null && treeNode.right == null) {
            map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
            if (map.get(treeNode.val) % 2 == 0) {
                map.remove(treeNode.val);
            }
            if (map.size() == 0 || map.size() == 1) {
                map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
                if (map.get(treeNode.val) % 2 == 0) {
                    map.remove(treeNode.val);
                }
                return 1;
            } else {
                map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
                if (map.get(treeNode.val) % 2 == 0) {
                    map.remove(treeNode.val);
                }
                return 0;
            }
        }
        map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
        if (map.get(treeNode.val) % 2 == 0) {
            map.remove(treeNode.val);
        }
        int left = 0, right = 0;
        if (treeNode.left != null) left = get(treeNode.left, map);
        if (treeNode.right != null) right = get(treeNode.right, map);
        map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
        if (map.get(treeNode.val) % 2 == 0) {
            map.remove(treeNode.val);
        }
        return left + right;
    }
}














