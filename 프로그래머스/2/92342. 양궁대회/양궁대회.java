import java.util.*;

class Solution {
    static int max;
    static int[] lion;
    static Map<Integer, List<int[]>> map;

    public int[] solution(int n, int[] info) {
        max = Integer.MIN_VALUE;
        lion = new int[info.length];
        map = new HashMap<>();
        backtrack(0, 0, n, info);

        int[] result = new int[2];
        result[0] = Integer.MIN_VALUE;
        List<int[]> list = map.get(max);
        if (list == null) return new int[] {-1};

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = o1.length - 1; i >= 0; i--) {
                    if (o1[i] == o2[i]) continue;
                    if (o1[i] > o2[i]) return -1;
                    if (o1[i] < o2[i]) return 1;
                }
                return 0;
            }
        });
        
        for (int[] x : list) {
            System.out.println(Arrays.toString(x));
        }
        
        return list.get(0);
    }

    private void backtrack(int level, int start, int n, int[] info) {
        if (level == n) {
            int sumLion = 0;
            int sumPeach = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] != 0 && info[i] >= lion[i]) {
                    sumPeach += (10 - i);
                } else if (lion[i] > info[i]) {
                    sumLion += (10 - i);
                }
            }

            // 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우,
            // 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요.
            int gap = sumLion - sumPeach;
            if (sumLion > sumPeach &&  gap >= max) {
                max = gap;
                int[] result = lion.clone();
                
                if (map.get(max) == null) {
                    List<int[]> list = new ArrayList<>();
                    list.add(result);
                    map.put(max, list);
                } else {
                    map.get(max).add(result);
                }
            }

            return;
        }

        for (int i = start; i < info.length; i++) {
            if (lion[i] > info[i]) continue;
            lion[i]++;
            backtrack(level + 1, i, n, info);
            lion[i]--;
        }
    }
}