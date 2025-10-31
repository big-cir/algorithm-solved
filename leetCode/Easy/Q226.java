// sol1: recursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);

        TreeNode tmp = new TreeNode();
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        return root;
    }
}

// sol2: queue
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();

            if (now.left != null) {
                queue.offer(now.left);
            }

            if (now.right != null) {
                queue.offer(now.right);
            }

            TreeNode tmp = now.left;
            now.left = now.right;
            now.right = tmp;
        }

        return root;
    }
}
