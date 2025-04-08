import java.util.*;

// 접근: 모든 종류의 보석을 포함하는 가장 짧은 구간. 보석 종류의 갯수를 미리 구하고, 인덱스를 탐색하면서 가장 작은 윈도우를 찾기.
// 시간복잡도: O(N logN)
// 풀이: Set, Hash, 슬라이딩 윈도우

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) gemSet.add(gem);
        
        int destSize = gemSet.size();
        Map<String, Integer> map = new HashMap<>();
        int lt = -1;
        int min = Integer.MAX_VALUE;
        
        List<int[]> answer = new ArrayList<>();
        for (int rt = 0; rt < gems.length; rt++) {
            String gem = gems[rt];
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            
            while (map.size() == destSize && lt < rt) {
                if (rt - lt < min) {
                    answer.add(new int[] {lt, rt});
                    min = (rt - lt);
                }
                
                String prevGem = gems[++lt];
                map.put(prevGem, map.get(prevGem) - 1);
                if (map.get(prevGem) == 0) {
                    map.remove(prevGem);
                }
            }
        }
        
        Collections.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        
        int[] result = answer.get(0);
        result[0] += 2;
        result[1] += 1;
        return result;
    }
}