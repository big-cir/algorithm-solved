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
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    const arr = [];
    inOrder(root, arr);

    return arr[k - 1];
};

const inOrder = (node, arr) => {
    if (node === null) return;

    inOrder(node.left, arr);
    arr.push(node.val);
    inOrder(node.right, arr);
}
