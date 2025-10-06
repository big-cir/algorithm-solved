// so1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}

// sol2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        int size = n + m;
        int[] tmp = new int[size];
        sort(0, size - 1, nums1, tmp);
    }

    private void sort(int start, int end, int[] nums1, int[] tmp) {
        if (start >= end) return;
        
        int mid = start + (end - start) / 2;
        sort(start, mid, nums1, tmp);
        sort(mid + 1, end, nums1, tmp);

        for (int i = start; i <= end; i++) {
            tmp[i] = nums1[i];
        }

        int afterStart = start;
        int afterEnd = mid + 1;
        int mergeArrIdx = start;
        while (afterStart <= mid && afterEnd <= end) {
            if (tmp[afterStart] <= tmp[afterEnd]) {
                nums1[mergeArrIdx++] = tmp[afterStart++];
            } else {
                nums1[mergeArrIdx++] = tmp[afterEnd++];
            }
        }

        while (afterStart <= mid) {
            nums1[mergeArrIdx++] = tmp[afterStart++];
        }
    }
}
