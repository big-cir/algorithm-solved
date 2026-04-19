// two point
class Solution {
    public int maxVowels(String s, int k) {
        int rt = k;
        int cnt = 0;
        for (int i = 0; i < rt; i++) {
            if (isVowel(s.charAt(i))) cnt++;
        }

        int answer = cnt;
        for (int lt = 0; lt < s.length() - k; lt++) {
            char ltc = s.charAt(lt);
            char rtc = s.charAt(rt++);
            if (isVowel(ltc)) cnt--;
            if (isVowel(rtc)) cnt++;
            answer = Math.max(answer, cnt);

            if (answer == k) break;
        }

        return answer;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

// prefix sum
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int[] sum = new int[s.length() + 1];
        for (int i = 1; i < sum.length; i++) {
            char ch = s.charAt(i - 1);
            sum[i] = sum[i - 1];
            if (set.contains(ch)) sum[i]++;
        }

        int answer = 0;
        for (int i = 0; i < sum.length - k; i++) {
            answer = Math.max(answer, sum[i + k] - sum[i]);
        }

        return answer;
    }
}
