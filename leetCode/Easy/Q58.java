class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            String str = arr[i];
            if (str.trim().length() == 0) continue;

            return str.length();
        }

        return 0;
    }
}
