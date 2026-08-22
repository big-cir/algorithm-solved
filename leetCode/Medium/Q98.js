/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
    function search(node, left, right) {
        if (node === null) return true;

        const cur = node.val;
        if (left < cur && cur < right) {
            return search(node.left, left, cur) && search(node.right, cur, right);
        }

        return false;
    }

    return search(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
};
