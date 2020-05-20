package 树;

import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/8 22:18
 */
public class N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return get(root, 1);
    }

    public int get(Node root, int cen) {
        if (root == null) {
            return cen;
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(get(node, cen + 1), max);
        }
        return max + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
