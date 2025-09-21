class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int answer = 0;
        int lastMin = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= lastMin) {
                lastMin = interval[1];
            } else {
                answer++;
            }
        }

        return answer;
    }
}
