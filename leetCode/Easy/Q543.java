/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }ㅎ
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  
    static int answer;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        answer = 0;
        helper(root);

        return answer;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int ld = helper(node.left);
        int rd = helper(node.right);
        answer = Math.max(answer, ld + rd);

        return Math.max(ld, rd) + 1;
    }
}
