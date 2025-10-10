class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char prev = s.charAt(0);
        boolean flag = false;
        int answer = map.get(prev);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if ((current == 'V' && prev == 'I') ||
                (current == 'X' && prev == 'I') ||
                (current == 'C' && prev == 'X') ||
                (current == 'L' && prev == 'X') ||
                (current == 'D' && prev == 'C') ||
                (current == 'M' && prev == 'C') && !flag
            ) {
                answer += ((map.get(current) - map.get(prev)) - map.get(prev));
                flag = true;
            } else {
                answer += map.get(current);
                prev = current;
                flag = false;
            }
        }

        return answer;
    }
}


// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
