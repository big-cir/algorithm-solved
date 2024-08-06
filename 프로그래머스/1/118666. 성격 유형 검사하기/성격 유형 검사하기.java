import java.util.*;

class Solution {
    
    static int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
    static List<String> types = List.of("R", "T", "C", "F", "J", "M", "A", "N");
    
    public static String solution(String[] survey, int[] choices) {
        Map<String, Integer> typeScore = new HashMap<>();
        for (String type : types) {
            typeScore.put(type, 0);
        }

        int n = survey.length;
        for (int i = 0; i < n; i++) {
            String[] info = survey[i].split("");
            String front = info[0];
            String back = info[1];

            int choice = choices[i];
            if (choice > 4) {
                typeScore.replace(back, typeScore.get(back) + scores[choice]);
            } else if (choice < 4) {
                typeScore.replace(front, typeScore.get(front) + scores[choice]);
            }
        }

        String answer = "";
        for (int i = 0; i < types.size(); i += 2) {
            String front = types.get(i);
            String back = types.get(i + 1);

            int frontScore = typeScore.get(front);
            int backScore = typeScore.get(back);

            if (frontScore > backScore) answer += front;
            else if (frontScore < backScore) answer += back;
            else {
                if (front.compareTo(back) < 0) {
                    answer += front;
                } else {
                    answer += back;
                }
            }
        }

        return answer;
    }
}