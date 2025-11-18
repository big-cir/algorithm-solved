/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int answer = Integer.MAX_VALUE;
        int lt = 1, rt = n;
        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (isBadVersion(mid)) {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
}
