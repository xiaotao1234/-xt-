package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/5/14 22:31
 */
public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return get(nums, 0, nums.length - 1);
    }

    public TreeNode get(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode1 = new TreeNode(nums[mid]);
        treeNode1.left = get(nums, left, mid - 1);
        treeNode1.right = get(nums, mid + 1, right);
        return treeNode1;
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
