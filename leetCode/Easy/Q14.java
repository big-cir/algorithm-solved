// sol1: O(nlogn + n * m)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });

        Map<String, Integer> map = new HashMap<>();
        String s1 = strs[0];
        for (int i = 1; i <= s1.length(); i++) {
            map.put(s1.substring(0, i), 0);
        }

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            Set<String> keys = map.keySet();
            for (String key : keys) {
                if (str.startsWith(key)) {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }

        String answer = "";
        for (String key : map.keySet()) {
            if (map.get(key) == strs.length - 1 && answer.length() < key.length()) answer = key;
        }

        return answer;
    }
}

// sol2: O(nlogn)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        String answer = "";
        int idx = 0;
        while (idx < str1.length()) {
            if (str1.charAt(idx) == str2.charAt(idx)) {
                answer += str1.charAt(idx++);
            } else break;
        }

        return answer;
    }
}
