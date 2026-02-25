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

// Union-Find
class Solution {

    static int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        Map<String, Integer> emailToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToIdx.containsKey(email)) {
                    union(i, emailToIdx.get(email));
                } else {
                    emailToIdx.put(email, i);
                }
            }
        }
        
        Map<Integer, TreeSet<String>> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int index = find(i);
            result.computeIfAbsent(index, k -> new TreeSet<>());

            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                result.get(index).add(email);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        for (int index : result.keySet()) {
            List<String> sub = new ArrayList<>();
            String name = accounts.get(index).get(0);
            sub.add(name);
            sub.addAll(result.get(index));

            answer.add(sub);
        }

        return answer;
    }

    private void union(int a, int b) {
        int na = find(a);
        int nb = find(b);
        parent[na] = nb;
    }

    private int find(int x) {
        if (parent[x] != x) {
            int nx = parent[x];
            parent[x] = find(nx);
        }

        return parent[x];
    }
}
