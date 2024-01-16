import java.util.Arrays;
class Solution {
    public int[] solution(String my_string) {
        int[] ints = Arrays.stream(my_string.split(""))
                .filter(x -> x.matches("^[0-9]"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(ints);
        return ints;
    }
}