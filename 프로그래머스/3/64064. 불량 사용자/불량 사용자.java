import java.util.*;
            
class Solution {
    static Set<String> set;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        bfs(user_id, banned_id);
        return set.size();
    }

    private void bfs(String[] user_id, String[] banned_id) {
        Queue<String[]> queue = new LinkedList<>();
        int banIdx = 0;
        String banPattern = banned_id[banIdx++];
        for (int i = 0; i < user_id.length; i++) {
            String user = user_id[i];

            if (!isMatched(user, banPattern)) continue;

            queue.offer(new String[] {user + " ", String.valueOf(banIdx)});
        }

        while (!queue.isEmpty()) {
            String[] poll = queue.poll();
            String key = poll[0];
            int idx = Integer.parseInt(poll[1]);

            if (idx  == banned_id.length) {
                String[] strs = key.split(" ");
                Arrays.sort(strs);
                String result = String.join("", strs);
                set.add(result);
                continue;
            }

            if (idx >= banned_id.length) continue;

            for (int i = 0; i < user_id.length; i++) {
                String user = user_id[i];

                Set<String> subSet = new HashSet<>(Arrays.asList(key.split(" ")));
                if (subSet.contains(user)) continue;

                if (isMatched(user, banned_id[idx])) {
                    queue.offer(new String[] {key + user + " ", String.valueOf(idx + 1)});
                }
            }
        }
    }

    private boolean isMatched(String user, String pattern) {
        if (user.length() != pattern.length()) return false;
        int idx = 0;
        while (idx < user.length()) {
            if (pattern.charAt(idx) != '*') {
                if (user.charAt(idx) != pattern.charAt(idx)) return false;
            }

            idx++;
        }

        return true;
    }
}