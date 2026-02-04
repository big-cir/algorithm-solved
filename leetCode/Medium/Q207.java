class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean answer = true;
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int a = prerequisite[0], b = prerequisite[1];
            indegree[b]++;
            graph.get(a).add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            
            for (int next : graph.get(course)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int x : indegree) {
            if (x != 0) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
