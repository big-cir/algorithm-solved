import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int min = arr[0];

        for (int x : arr) {
            if (min > x) min = x;
            list.add(x);
        }

        list.remove(Integer.valueOf(min));

        if (list.size() == 0) {
            return new int[] {-1};
        } else {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}