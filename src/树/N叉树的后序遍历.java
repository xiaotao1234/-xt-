package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/9 23:05
 */
public class N叉树的后序遍历 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        get(root, list);
        return list;
    }

    public void get(Node node, List<Integer> list) {
        if(node==null){
            return;
        }
        for (Node node1 : node.children) {
            get(node1, list);
        }
        list.add(node.val);
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
