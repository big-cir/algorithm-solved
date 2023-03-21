class Solution {
    public static int[] odd(int num, int total, int[] answer) {
        int mid = total / num;
        int m_idx = answer.length / 2;
        answer[m_idx] = mid;

        for (int i = 0; i < m_idx; i++) {
            int left = i;
            int right = answer.length - 1 - i;

            answer[left] = answer[m_idx] - m_idx + i;
            answer[right] = answer[m_idx] + m_idx - i;
        }

        return answer;
    }

    public static int[] even(int num, int total, int[] answer) {
        int m_idx = answer.length / 2 - 1;
        int mid = total / num;
        answer[m_idx] = mid;
        answer[m_idx + 1] = mid + 1;

        for (int i = 0; i < m_idx; i++) {
            int left = i;
            int right = answer.length - 1 - i;

            answer[left] = answer[m_idx] - m_idx + i;
            answer[right] = answer[m_idx + 1] + m_idx - i;
        }
        return answer;
    }

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if (num % 2 == 0) {
            return even(num, total, answer);
        } else {
            return odd(num, total, answer);
        }
    }
}