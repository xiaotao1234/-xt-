package 树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/11 16:01
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return get(nums, 0, nums.length - 1);
    }

    public TreeNode get(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = getMax(nums, left, right);
        TreeNode treeNode = new TreeNode(nums[maxIndex]);
        treeNode.left = get(nums, left, maxIndex - 1);
        treeNode.right = get(nums, maxIndex + 1, right);
        return treeNode;
    }

    public int getMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = left;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
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
