import java.util.*;

// 선물을 더 준 사람이 다음달에 받음
// 기록이 없거나 같다면, 큰사람 -> 작은사람 (지수 : 준 선물 - 받은 선물), 지수도 같으면 주고받지 않음
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // int[] : 준 선물, 받은 선물, 지수
        Map<String, int[]> map = new HashMap<>();

        // 누구에게 받았는지 기록
        Map<String, Map<String, Integer>> table = new HashMap<>();

        Map<String, Integer> result = new HashMap<>();

        for (String friend : friends) {
            map.put(friend, new int[3]);
            table.put(friend, new HashMap<String, Integer>());
            result.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] info = gift.split(" ");

            String give = info[0];
            String receive = info[1];

            if (map.containsKey(give)) {
                int[] gPrevious = map.get(give);
                gPrevious[0]++;
                update(gPrevious);
                map.replace(give, gPrevious);
            } else {
                int[] arr = new int[] {1, 0, 1};
                map.put(give, arr);
            }

            if (map.containsKey(receive)) {
                int[] rPrevious = map.get(receive);
                rPrevious[1]++;
                update(rPrevious);
                map.replace(receive, rPrevious);
            } else {
                int[] arr = new int[] {0, 1, -1};
                map.put(receive, arr);
            }

            // 누가 나한테 줬는지 기록
            Map<String, Integer> cnt = table.get(receive);
            cnt.put(give, cnt.getOrDefault(give, 0) + 1);
            for (String f : friends) {
                if (f.equals(receive) || cnt.containsKey(f)) continue;
                cnt.put(f, 0);
            }
            table.replace(receive, cnt);
        }

        Set<String> set = new HashSet<>();

        for (String name : table.keySet()) {
            Map<String, Integer> receiveRecord = table.get(name);

            // 나에게 준 사람 리스트
            for (String givenFriend : receiveRecord.keySet()) {
                String str1 = name + givenFriend;
                String str2 = givenFriend + name;
                if (set.contains(str1) || set.contains(str2)) continue;

                Map<String, Integer> friendInfo = table.get(givenFriend);

                int nameGiveCnt = 0;
                // 내가 준 갯수, 내가 받은 갯수
                if (friendInfo.containsKey(name)) nameGiveCnt = friendInfo.get(name);
                int nameRecreceiveRecord = receiveRecord.get(givenFriend);

                if (nameGiveCnt == nameRecreceiveRecord) {
                    if (map.get(name)[2] > map.get(givenFriend)[2]) {
                        result.replace(name , result.get(name) + 1);
                    } else if (map.get(name)[2] < map.get(givenFriend)[2]) {
                        result.replace(givenFriend , result.get(givenFriend) + 1);
                    }
                } else if (nameGiveCnt > nameRecreceiveRecord) {
                    result.replace(name , result.get(name) + 1);
                } else if (nameGiveCnt < nameRecreceiveRecord) {
                    result.replace(givenFriend , result.get(givenFriend) + 1);
                }

                set.add(str1);
                set.add(str2);
            }
        }

        System.out.println(result);

        int answer = 0;
        for (int num : result.values()) {
            answer = Math.max(answer, num);
        }

        return answer;
    }

    private void update(int[] arr) {
        arr[2] =  arr[0] - arr[1];
    }
    
}
