class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            answer <<= 1;
            answer += (n & 1);
            n >>= 1;
        }

        return answer;
    }
}

class Solution {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}

class Solution {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        binary = String.format("%32s", binary).replace(' ', '0');
        String reversed = new StringBuilder(binary).reverse().toString();
        
        return Integer.parseInt(reversed, 2);
    }
}
