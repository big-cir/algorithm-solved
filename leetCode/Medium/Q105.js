/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    const inMap = new Map();
    for (let i = 0; i < inorder.length; i++) {
        inMap.set(inorder[i], i);
    }

    function helper(pl, pr, il, ir) {
        if (pl > pr || il > ir) return null;

        const rootVal = preorder[pl];
        const node = new TreeNode(rootVal);

        const midIdx = inMap.get(rootVal);
        node.left = helper(pl + 1, pl + (midIdx - il), il, midIdx - 1);
        node.right = helper(pl + (midIdx - il) + 1, pr, midIdx + 1, ir);

        return node;
    }
    
    return helper(0, preorder.length - 1, 0, inorder.length - 1);
};
