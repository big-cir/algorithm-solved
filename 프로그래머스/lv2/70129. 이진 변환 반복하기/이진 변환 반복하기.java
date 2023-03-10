class Solution {
    public int[] changeBinary(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int zCount = 0;
        while (s.length() != 1) {
            count++;
            String change = "";
            sb.setLength(0);
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zCount++;
                    continue;
                }
                change += c;
            }

            int n = change.length();
            while (n > 0) {
                int x = n % 2;
                sb.append(x);
                n /= 2;
            }
            change = sb.reverse().toString();
            s = change;
        }

        return new int[] {count, zCount};
    }

    public int[] solution(String s) {
        int[] answer = changeBinary(s);
        return answer;
    }
}