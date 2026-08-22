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
 * @return {number[]}
 */
var rightSideView = function(root) {
    const map = new Map();
    function search(node, level) {
        if (node === null) return;
        if (!map.has(level)) map.set(level, []);
        map.get(level).push(node.val);
        search(node.left, level + 1);
        search(node.right, level + 1);
    }

    const answer = [];
    search(root, 0);
    for (let i = 0; i < map.size; i++) {
        const arr = map.get(i);
        answer.push(arr[arr.length - 1]);
    }

    return answer;
};
