// Bit Shifting: O(1)
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int nLastBit = n & 1;
            if (nLastBit == 1) count++;
            n >>= 1;
        }

        return count;
    }
}
