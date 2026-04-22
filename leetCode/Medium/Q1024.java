// greedy
class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int[] maxReached = new int[time + 1];
        for (int[] clip : clips) {
            int start = clip[0], end = clip[1];
            if (start <= time) maxReached[start] = Math.max(maxReached[start], end);
        }

        int answer = 0;
        int end = 0;
        int farEnd = 0;
        for (int i = 0; i < time; i++) {
            farEnd = Math.max(farEnd, maxReached[i]);
            if (i == end) {
                answer++;
                end = farEnd;
            }
        }

        return end < time ? -1 : answer;
    }
}

// dp
class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int[] result = new int[time + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int t = 1; t <= time; t++) {
            for (int[] clip : clips) {
                int start = clip[0], end = clip[1];

                if (start > t || end < t || result[start] == Integer.MAX_VALUE) continue;
                result[t] = Math.min(result[t], result[start] + 1);
            }
        }

        return result[time] == Integer.MAX_VALUE ? -1 : result[time];
    }
}
