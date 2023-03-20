class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 3; i <= 5000; i++) {
            for (int j = 3; j <= i; j++) {
                int brown_count = (i + j - 2) * 2;
                int yellow_count = (i * j - brown_count);

                if (brown == brown_count && yellow == yellow_count) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}