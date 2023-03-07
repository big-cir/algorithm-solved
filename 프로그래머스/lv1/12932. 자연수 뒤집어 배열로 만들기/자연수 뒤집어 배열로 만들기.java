class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        String str = Long.toString(n);
        StringBuilder reverse = sb.append(str).reverse();


        int[] answer = new int[reverse.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(reverse.substring(i, i + 1));
        }
        return answer;
    }
}