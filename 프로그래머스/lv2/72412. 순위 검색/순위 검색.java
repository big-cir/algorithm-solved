import java.util.*;
class Solution {
    static Map<String, List<Integer>> map;

    private static void combi(String[] token) {
        String[] langs = {token[0], "-"};
        String[] jobs = {token[1], "-"};
        String[] carrers = {token[2], "-"};
        String[] foods = {token[3], "-"};
        int score = Integer.parseInt(token[4]);

        for (String lang : langs) {
            for (String job : jobs) {
                for (String carrer : carrers) {
                    for (String food : foods) {
                        String key = new StringBuilder().append(lang + " ").append(job + " ").append(carrer + " ").append(food).toString();
                        List<Integer> scores = map.getOrDefault(key, new ArrayList<>());
                        scores.add(score);

                        map.put(key, scores);
                    }
                }
            }
        }
    }
    
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();

        for (String str : info) {
            String[] token = str.split(" ");
            combi(token);
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        int i = 0;

        for (String q : query) {
            String[] inData = q.split(" and ");
            int val = Integer.parseInt(inData[3].split(" ")[1]);
            inData[3] = inData[3].split(" ")[0];
            String key = new StringBuilder().append(inData[0] + " ")
                    .append(inData[1] + " ").append(inData[2] + " ").append(inData[3]).toString();

            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);

                int lt = 0;
                int rt = list.size();

                while (lt < rt) {
                    int mid = (lt + rt) / 2;            

                    if (val <= list.get(mid)) {
                        rt = mid;
                    } else {
                        lt = mid + 1;
                    }
                }

                answer[i] = list.size() - lt;
            }
            i++;
        }
        return answer;
    }
}
