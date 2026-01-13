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
