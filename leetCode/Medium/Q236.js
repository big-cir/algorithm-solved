/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

const depth = new Map();
const parent = new Map();

var lowestCommonAncestor = function(root, p, q) {
    depth.clear();
    parent.clear();
    search(root, 0, null);

    while (p !== q) {
        if (depth.get(p.val) === depth.get(q.val)) {
            p = parent.get(p.val);
            q = parent.get(q.val);
        } else if (depth.get(p.val) > depth.get(q.val)) {
            p = parent.get(p.val);
        } else {
            q = parent.get(q.val);
        }
    }

    return p;
};

const search = (node, d, pNode) => {
    depth.set(node.val, d);
    parent.set(node.val, pNode);

    if (node.left !== null) search(node.left, d + 1, node);
    if (node.right !== null) search(node.right, d + 1, node);
}
