// BFS 시간복잡도: O(N logN)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> emailGraph = new HashMap<>();
        Map<String, String> emailToNameGraph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailGraph.computeIfAbsent(firstEmail, k -> new HashSet<>()).add(email);
                emailGraph.computeIfAbsent(email, k -> new HashSet<>()).add(firstEmail);
                emailToNameGraph.put(email, name);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : emailGraph.keySet()) {
            if (visited.contains(email)) continue;

            String name = emailToNameGraph.get(email);
            List<String> result = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(email);
            visited.add(email);
            while (!queue.isEmpty()) {
                String current = queue.poll();
                result.add(current);

                for (String next : emailGraph.get(current)) {
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            Collections.sort(result);
            result.add(0, name);
            answer.add(result);
        }

        return answer;
    }
}
