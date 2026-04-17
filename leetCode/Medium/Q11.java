// 시간복잡도: O(N)
class Solution {
    public int maxArea(int[] height) {
        int lt = 0, rt = height.length - 1;
        int answer = 0;
        while (lt < rt) {
            int lh = height[lt];
            int rh = height[rt];
            answer = Math.max(
                answer,
                Math.min(lh, rh) * (rt - lt)
            );

            // 높이가 더 작은 포인트 이동
            if (lh < rh) {
                lt++;
            } else {
                rt--;
            }
        }

        return answer;
    }
}

//
class Solution {
    public int maxArea(int[] height) {
        int p1 = 0, p2 = height.length - 1;
        int answer = 0;
        while (p1 < p2) {
            int p1V = height[p1];
            int p2V = height[p2];

            if (p1V < p2V) {
                answer = Math.max(answer, (p2 - p1) * p1V);
                p1++;
            } else {
                answer = Math.max(answer, (p2 - p1) * p2V);
                p2--;
            }
        }

        return answer;
    }
}
