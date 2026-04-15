// Stack & Queue
class Solution {
    public String reverseVowels(String s) {
        Stack<Character> vowels = new Stack<>();
        Queue<Integer> originIndex = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowels.push(ch);
                originIndex.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (originIndex.isEmpty()) {
                sb.append(s.charAt(i));
                continue;
            }

            int peek = originIndex.peek();
            if (peek == i) {
                sb.append(vowels.pop());
                originIndex.poll();
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

// two point
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int p1 = 0, p2 = n -1;
        while (p1 < p2) {
            char p1Char = sb.charAt(p1);
            char p2Char = sb.charAt(p2);

            if (isVowel(p1Char) && isVowel(p2Char)) {
                swap(p1, p2, sb);
                p1++;
                p2--;
            } else if (isVowel(p1Char)) {
                p2--;
            } else {
                p1++;
            }
        }

        return sb.toString();   
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private void swap(int p1, int p2, StringBuilder sb) {
        char tmp = sb.charAt(p1);
        sb.setCharAt(p1, sb.charAt(p2));
        sb.setCharAt(p2, tmp);
    }
}
