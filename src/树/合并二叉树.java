package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/7 23:52
 */
public class 合并二叉树 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode get(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null) {
            return treeNode2;
        }
        if (treeNode2 == null) {
            return treeNode1;
        }
        treeNode1.val += treeNode2.val;
        treeNode1.left = get(treeNode1.left, treeNode2.left);
        treeNode1.right = get(treeNode1.right, treeNode2.right);
        return treeNode1;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
