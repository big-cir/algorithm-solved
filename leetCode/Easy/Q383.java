class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        
        for (char ch : ransomNote.toCharArray()) {
            if (--count[ch - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : magazine.toCharArray()) {
            if (map.containsKey(ch)) {
                int value = map.get(ch) - 1;
                if (value == 0) {
                    map.remove(ch);
                } else {
                    map.replace(ch, value);
                }
            }
        }

        return map.isEmpty();
    }
}
