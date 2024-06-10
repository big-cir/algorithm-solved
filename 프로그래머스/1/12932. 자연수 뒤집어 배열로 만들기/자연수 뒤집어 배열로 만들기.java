import java.util.*;
class Solution {
    public int[] solution(long n) {
        return Arrays.stream(new StringBuffer(String.valueOf(n)).reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
    }
}