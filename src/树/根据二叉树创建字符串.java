package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/9 21:45
 */
public class 根据二叉树创建字符串 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        String s = "";
        if (left.length() != 0 || right.length() != 0) {
            s = "(" + left + ")";
        }
        if (right.length() != 0) {
            s = s + "(" + right + ")";
        }
        return t.val + s;
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
