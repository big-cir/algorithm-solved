/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BST ordering property: O(log N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        int currentVal = root.val;
        int pv = p.val, qv = q.val;

        if (currentVal > pv && currentVal > qv) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (currentVal < pv && currentVal < qv) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}


// O(N)
class Solution {

    static Map<Integer, Integer> parent;
    static Map<Integer, Integer> depth;
    static Map<Integer, TreeNode> store;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        parent = new HashMap<>();
        depth = new HashMap<>();
        store = new HashMap<>();
        
        int value = root.val;
        parent.put(value, -1);
        depth.put(value, 0);
        store.put(value, root);
        helper(value, root);

        int pv = p.val, qv = q.val;
        while (pv != qv) {
            if (depth.get(pv) == depth.get(qv)) {
                pv = parent.get(pv);
                qv = parent.get(qv);
            } else if (depth.get(pv) > depth.get(qv)) {
                pv = parent.get(pv);
            } else {
                qv = parent.get(qv);
            }
        }

        return store.get(pv);
    }

    public void helper(int parentValue, TreeNode node) {
        if (node == null) return;

        int value = node.val;
        parent.put(value, parentValue);
        depth.put(value, depth.get(parentValue) + 1);
        store.put(value, node);

        helper(value, node.left);
        helper(value, node.right);
    }
}
