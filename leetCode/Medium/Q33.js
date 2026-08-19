/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let lt = 0, rt = nums.length - 1;
    while (lt <= rt) {
        const mid = Math.floor((lt + rt) / 2);
        const mv = nums[mid];

        if (mv === target) return mid;

        if (mv >= nums[lt]) {
            if (nums[lt] <= target && target < mv) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        } else {
            if (mv < target && target <= nums[rt]) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
    }

    return -1;
};
