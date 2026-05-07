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
    public int goodNodes(TreeNode root) {
        int answer = 0;
        int rootVal = -1;
        if (root != null) {
            answer = 1;
            rootVal = root.val;
        }

        answer += helper(root.right, rootVal);
        answer += helper(root.left, rootVal);

        return answer;
    }

    private int helper(TreeNode node, int rootVal) {
        if (node == null) return 0;

        int result = 0;
        if (node.val >= rootVal) result++;
        int maxVal = Math.max(rootVal, node.val);
        result += helper(node.right, maxVal);
        result += helper(node.left, maxVal);

        return result;
    }
}
