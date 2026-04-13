class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int[] answer = new int[3];
        answer[0] = nums[0];
        int size = 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (answer[size - 1] < num) {
                answer[size++] = num;
            } else {
                for (int j = 0; j < size; j++) {
                    if (answer[j] >= num) {
                        answer[j] = num;
                        break;
                    }
                }
            }

            if (size == 3) return true;
        }

        return false;
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        for (int p3 = 0; p3 < n; p3++) {
            int num = nums[p3];
            if (num <= p1) p1 = num;
            else if (num <= p2) p2 = num;
            else return true;
        }

        return false;
    }
}
