import java.util.Arrays;
class Solution {
    public long solution(long n) {
        String answer = "";
        int[] arr = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            answer += String.valueOf(arr[i]);
        }

        return Long.parseLong(answer);
    }
}