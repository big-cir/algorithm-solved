class Solution {
    public void setZeroes(int[][] matrix) {
        Map<String, Set<Integer>> map = new HashMap<>();
        map.put("row", new HashSet<>());
        map.put("col", new HashSet<>());

        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    map.get("row").add(i);
                    map.get("col").add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get("row").contains(i) || map.get("col").contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
