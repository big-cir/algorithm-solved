class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int x : stones) pq.offer(x);
        while (pq.size() > 1) {
            int v1 = pq.poll();
            int v2 = pq.poll();
            pq.offer(Math.abs(v1 - v2));
        }

        return pq.poll();
    }
}
