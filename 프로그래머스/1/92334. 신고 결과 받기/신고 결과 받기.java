
import java.util.*;
class Solution {
    static Map<String, List<String>> map;
    static Map<String, Integer> reported;
    public int[] solution(String[] id_list, String[] report, int k) {
        map = new HashMap<>();
        for (String user : id_list) map.put(user, new ArrayList<>());
        
        reported = new HashMap<>();
        for (String str : report) {
            String[] sArr = str.split(" ");
            String s1 = sArr[0];
            String s2 = sArr[1];
            
            if (!map.get(s1).contains(s2)) {
                map.get(s1).add(s2);
                reported.put(s2, reported.getOrDefault(s2, 0) + 1);
            }    
        }
        
        Set<String> banId = new HashSet<>();
        for (String reportedId : reported.keySet()) {
            if (reported.get(reportedId) >= k) banId.add(reportedId);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            String repoter = id_list[i];
            for (String reportId : map.get(repoter)) {
                if (banId.contains(reportId)) cnt ++;
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}