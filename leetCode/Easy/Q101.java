// sol1: pre/post order compare
// 시간복잡도 O(n), 공간복잡도 O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        preOrder(root.left, left);
        postOrder(root.right, right);

        boolean answer = true;
        if (left.size() != right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            if (left.get(left.size() - 1 - i) != right.get(i)) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    private void preOrder(TreeNode node, List<Integer> left) {
        if (node == null) {
            left.add(-101);
            return;
        }

        left.add(node.val);
        preOrder(node.left, left);
        preOrder(node.right, left);
    }

    private void postOrder(TreeNode node, List<Integer> right) {
        if (node == null) {
            right.add(-101);
            return;
        }

        postOrder(node.left, right);
        postOrder(node.right, right);
        right.add(node.val);
    }
}

// sol2: recursive
// 시간복잡도 O(n), 공간복잡도 O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        boolean current = left.val == right.val;
        boolean result1 = helper(left.left, right.right);
        boolean result2 = helper(left.right, right.left);

        return current && result1 && result2;
    }
}
