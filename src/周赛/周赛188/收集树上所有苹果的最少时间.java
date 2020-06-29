package 周赛188;

import 树.N叉树的前序遍历;
import 树.二叉树的最大深度;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/10 10:52
 */
public class 收集树上所有苹果的最少时间 {

    public static void main(String[] args) {
        收集树上所有苹果的最少时间 s = new 收集树上所有苹果的最少时间();
        List<Boolean> list = new ArrayList<>();
        list.add(false);
        list.add(false);
        list.add(true);
        list.add(false);
        list.add(true);
        list.add(true);
        list.add(false);
        System.out.println(s.minTime1(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, list));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                TreeNode treeNode = map.get(edges[i][0]);
                if (treeNode.left == null) {
                    treeNode.left = new TreeNode(edges[i][1]);
                    map.put(edges[i][1], treeNode.left);
                } else {
                    treeNode.right = new TreeNode(edges[i][1]);
                    map.put(edges[i][1], treeNode.right);
                }
            } else {
                TreeNode treeNode = new TreeNode(edges[i][0]);
                map.put(edges[i][0], treeNode);
                treeNode.left = new TreeNode(edges[i][1]);
                map.put(edges[i][1], treeNode.left);
            }
        }
        int end = get(map.get(0), hasApple);
        if (end > 0) {
            return (end - 1) * 2;
        } else {
            return end;
        }
    }

    public int get(TreeNode treeNode, List<Boolean> hasApple) {
        if (treeNode == null) {
            return 0;
        }
        int left = get(treeNode.left, hasApple);
        int right = get(treeNode.right, hasApple);
        if (left > 0 || hasApple.get(treeNode.val) || right > 0) {
            return left + right + 1;
        } else {
            return 0;
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

    public int minTime1(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                Node treeNode = map.get(edges[i][0]);
//                if (treeNode.children.size() == 0) {
                Node node = new Node(edges[i][1], new ArrayList<>());
                treeNode.children.add(node);
                map.put(edges[i][1], node);
//                } else {
//                    treeNode.right = new TreeNode(edges[i][1]);
//                    map.put(edges[i][1], treeNode.right);
//                }
            } else {
                Node treeNode = new Node(edges[i][0], new ArrayList<>());
                map.put(edges[i][0], treeNode);
                Node node = new Node(edges[i][1],new ArrayList<>());
                map.put(edges[i][1], node);
                treeNode.children.add(node);
            }
        }
        int end = get1(map.get(0), hasApple);
        if (end > 0) {
            return (end - 1) * 2;
        } else {
            return end;
        }
    }

    public int get1(Node treeNode, List<Boolean> hasApple) {
        if (treeNode == null) {
            return 0;
        }
        int all = 0;
        for (Node node : treeNode.children) {
            all = get1(node, hasApple) + all;
        }
        if (all > 0 || hasApple.get(treeNode.val)) {
            return all + 1;
        } else {
            return 0;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
