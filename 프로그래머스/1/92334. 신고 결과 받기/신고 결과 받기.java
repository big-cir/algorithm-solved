import java.util.*;
// ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : id_list) {
            map.put(x, 0);
        }
        
        Map<String, List<String>> reportResult = new HashMap<>();
        for (String x : report) {
            String[] arr = x.split(" ");
            if (reportResult.containsKey(arr[1])) {
                if (!reportResult.get(arr[1]).contains(arr[0])) {
                    reportResult.get(arr[1]).add(arr[0]);
                }
            } else {
                reportResult.put(arr[1], new ArrayList<String>(List.of(arr[0])));
            }
        }
        
        for (String key : reportResult.keySet()) {
            List<String> reporters = reportResult.get(key);
            if (reporters.size() >= k) {
                for (String reporter : reporters) map.put(reporter, map.get(reporter) + 1);
            }
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        for (String id : id_list) answer[idx++] = map.get(id);
        return answer;
    }
}