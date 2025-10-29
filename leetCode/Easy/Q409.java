// so1: arr
class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[52];
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            } else {
                arr[ch - 'A' + 26]++;
            }
        }

        int answer = 0;
        boolean hasOddChar = false;
        for (int count : arr) {
            // if (count % 2 == 0) answer += count;
            // else {
            //     hasOddChar = true;
            //     answer += (count - 1);
            // }
            answer += (count / 2) * 2;
            if (count % 2 == 1) hasOddChar = true;
        }

        if (hasOddChar) answer++;

        return answer;
    }
}

// sol2: set
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int answer = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                answer += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        if (!set.isEmpty()) answer++;

        return answer;
    }
}
