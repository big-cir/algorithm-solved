class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int length = arr.length;
        int[] cnt = new int[2001];
        for (int x : arr) {
            if (x < 0) {
                cnt[Math.abs(x)]++;
            } else {
                cnt[1000 + x]++;
            }
        }

        Set<Integer> check = new HashSet<>();
        for (int x : cnt) {
            if (x == 0) continue;
            if (check.contains(x)) return false;
            check.add(x);
        }

        return true;
    }
}
