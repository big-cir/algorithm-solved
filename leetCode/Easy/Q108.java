/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        helper(0, mid - 1, nums, root);
        helper(mid + 1, nums.length - 1, nums, root);

        return root;
    }

    private void helper(int start, int end, int[] nums, TreeNode node) {
        if (start > end) return;
        int mid = (start + end) / 2;

        int value = nums[mid];
        TreeNode child = new TreeNode(value);
        if (node.val > value) {
            node.left = child;
        } else {
            node.right = child;
        }

        helper(start, mid - 1, nums, child);
        helper(mid + 1, end, nums, child);
    }
}
