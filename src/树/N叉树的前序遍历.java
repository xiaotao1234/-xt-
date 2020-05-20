package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/8 23:51
 */
public class N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        get(root,list);
        return list;
    }

    public void get(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node node1 : node.children) {
            get(node1, list);
        }
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
