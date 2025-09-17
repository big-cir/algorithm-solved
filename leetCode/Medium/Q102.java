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

    Map<Integer, List<Integer>> map;

    public List<List<Integer>> levelOrder(TreeNode root) {
        map = new HashMap<>();
        helper(0, root);

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            answer.add(map.get(i));
        }
        return answer;
    }

    private void helper(int depth, TreeNode node) {
        if (node == null) return;

        map.computeIfAbsent(depth, k -> new ArrayList<>()).add(node.val);

        helper(depth + 1, node.left);
        helper(depth + 1, node.right);
    }
}
