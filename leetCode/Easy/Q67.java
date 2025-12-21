// O(n)
class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1, p2 = b.length() - 1;
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int aBit = p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            int bBit = p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            int result = (aBit + bBit + carry);

            carry = result / 2;
            result %= 2;
            answer.append(result);
        }

        if (carry == 1) answer.append(1);
        return answer.reverse().toString();
    }
}
