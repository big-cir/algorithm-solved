class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        char[] chars = senate.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char cur = chars[i];
            if (cur == 'R') rq.offer(i);
            else dq.offer(i);
        }

        while (!rq.isEmpty() && !dq.isEmpty()) {
            int ri = rq.poll();
            int di = dq.poll();
            if (ri < di) {
                rq.offer(ri + n);
            } else {
                dq.offer(di + n);
            }
        }

        String answer = "Radiant";
        if (rq.isEmpty()) answer = "Dire";

        return answer;
    }
}
