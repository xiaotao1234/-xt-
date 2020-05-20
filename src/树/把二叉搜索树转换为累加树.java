package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/8 22:23
 */
public class 把二叉搜索树转换为累加树 {
    //思路1：用一个外部变量sum来记录当前访问过的所有节点的总和，按照先右后中再左，根据搜索二叉树的特性，是一个从大到小的节点遍历过程
    //思路2：当前节点的值等于当前节点的固有值加其上一个访问节点变化后的值
    //思路3：访问到当前节点时，要求当前节点的值，若当前节点没有右子树那么就代表所有大于当前节点的值都已经遍历过了，直接得出当前节点的值，
    // 否则再去遍历完其右子树，然后再得出当前节点的值
    public TreeNode convertBST(TreeNode root) {
        get(root, 0);
        return root;
    }

    public int get(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return 0;
        }
        sum = sum + get(treeNode.right, sum) + treeNode.val;
        treeNode.val = sum;
        sum = sum + get(treeNode.left, sum);
        return sum;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

    public TreeNode convertBST1(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            /*
             * If there is no right subtree, then we can visit this node and
             * continue traversing left.
             */
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
            /*
             * If there is a right subtree, then there is at least one node that
             * has a greater value than the current one. therefore, we must
             * traverse that subtree first.
             */
            else {
                TreeNode succ = getSuccessor(node);
                /*
                 * If the left subtree is null, then we have never been here before.
                 */
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                }
                /*
                 * If there is a left subtree, it is a link that we created on a
                 * previous pass, so we should unlink it and visit this node.
                 */
                else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/ba-er-cha-sou-suo-shu-zhuan-huan-wei-lei-jia-shu-3/
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
