// Greedy
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                idx++;
            } else {
                break;
            }
        }

        for (int i = idx; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[1]) break;
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            idx++;
        }
        result.add(newInterval);

        while (idx < intervals.length) {
            result.add(intervals[idx++]);
        }

        return result.toArray(new int[result.size()][2]);
    }
}

// Binary Search
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] range = new int[] {intervals.length, -1};
        int lt = 0, rt = intervals.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int[] interval = intervals[mid];
            if (interval[1] < newInterval[0]) {
                lt = mid + 1;
            } else {
                range[0] = mid;
                rt = mid - 1;
            }
        }

        lt = 0; rt = intervals.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int[] interval = intervals[mid];
            if (interval[0] > newInterval[1]) {
                rt = mid - 1;
            } else {
                range[1] = mid;
                lt = mid + 1;
            }
        }

        for (int i = 0; i < range[0]; i++) {
            result.add(intervals[i]);
        }

        if (range[0] <= range[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[range[0]][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[range[1]][1]);
        }
        result.add(newInterval);

        for (int i = range[1] + 1; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][2]);
    }
}
