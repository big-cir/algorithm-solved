// 시간복잡도: O(N)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int tmp = x;
        int comp = 0;
        while (tmp != 0) {
            comp *= 10;
            comp += (tmp % 10);
            tmp /= 10;
        }
        
        return x == comp;
    }
}

// 시간복잡도: O(N)
class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));

        return sb.toString().equals(sb.reverse().toString());
    }
}
