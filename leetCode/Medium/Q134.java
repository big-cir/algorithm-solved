class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int st = 0, sum = 0,prefixSum = 0;
        for (int i = 0; i < gas.length; i++) {
            int gap = gas[i] - cost[i];
            sum += gap;
            prefixSum += gap;

            if (prefixSum < 0) {
                prefixSum = 0;
                st = i + 1;
            }
        }

        if (sum < 0) return -1;
        return st;
    }
}
