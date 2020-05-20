package 每日一题;

import 树.从上到下打印二叉树2;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/7 0:53
 */
public class 另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        return get(s, t);
    }

    public boolean get(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            if (get1(s, t)) {
                return true;
            }
        } else {
            if (get(s.left, t) ||
                    get(s.right, t))
                return true;
        }
        return false;
    }

    public boolean get1(TreeNode s, TreeNode t) {
        if (t != null) {
            if (s == null) {
                return false;
            } else if (t.val == s.val) {
                if (get1(s.left, t.left) &&
                        get1(s.right, t.right))
                    return true;
                else
                    return false;
            } else {
                return false;
            }
        } else {
            return true;
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
}
