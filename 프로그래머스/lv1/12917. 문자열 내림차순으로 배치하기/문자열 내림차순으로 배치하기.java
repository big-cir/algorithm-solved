import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public String solution(String s) {
        List<Integer> collect = s.chars().boxed().collect(Collectors.toList());
        Collections.sort(collect, Collections.reverseOrder());

        String answer = "";
        for (int x : collect) {
            answer += (char) x;
        }
        return answer;
    }
}