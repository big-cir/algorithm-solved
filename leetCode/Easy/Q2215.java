class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int num : nums1) nums1Set.add(num);

        Set<Integer> nums2Set = new HashSet<>();
        for (int num : nums2) nums2Set.add(num);

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < 2; i++) answer.add(new ArrayList<>());
        
        for (int num : nums1Set) {
            if (!nums2Set.contains(num)) {
                answer.get(0).add(num);
            }
        }

        for (int num : nums2Set) {
            if (!nums1Set.contains(num)) {
                answer.get(1).add(num);
            }
        }

        return answer;
    }
}
