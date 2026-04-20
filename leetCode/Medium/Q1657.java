class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> word1Char = new HashMap<>();
        Map<Character, Integer> word2Char = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            word1Char.put(ch, word1Char.getOrDefault(ch, 0) + 1);
        }

        for (char word1Key : word1Char.keySet()) {
            int cnt = word1Char.get(word1Key);
            count.put(cnt, count.getOrDefault(cnt, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            word2Char.put(ch, word2Char.getOrDefault(ch, 0) + 1);
        }

        for (char word1Key : word1Char.keySet()) {
            Integer cnt = word2Char.get(word1Key);
            if (!word2Char.containsKey(word1Key) || !count.containsKey(cnt) || count.get(cnt) == 0) return false;
            count.put(cnt, count.get(cnt) - 1);
        }

        return true;
    }
}
