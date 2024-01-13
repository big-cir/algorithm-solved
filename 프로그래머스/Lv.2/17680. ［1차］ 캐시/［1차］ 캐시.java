import java.util.LinkedList;
import java.util.List;
// 도시 이름 검색 -> 맛집 게시물 보여주기

// cacheSize <= 30
// cities[].length <= 100,000
// city[0].length <= 20
// O(N^2) 10000000000

// +5 +5 +5
// 서울 판교 제주
// 뉴욕, 제주
class Solution {
    static final int HIT = 1;
    static final int MISS = 5;
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return MISS * cities.length;
        }


        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        LinkedList<String> store = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String now = cities[i];
            // 가득차지 않았을 때
            if (isFull(store, cacheSize)) {
                // 없을떄
                if (!store.contains(now)) {
                    answer += MISS;
                    store.addFirst(now);
                } else {
                    // 포함되어 있을 때
                    answer += HIT;
                    store.remove(now);
                    store.addFirst(now);

                }
            } else {    // 가득 찼을 때
                if (!store.contains(now)) { // 포함안됫을떄
                    answer += MISS;
                    store.pollLast();
                    store.addFirst(now);
                } else {
                    // 포함 됬을 때
                    answer += HIT;
                    store.remove(now);
                    store.addFirst(now);
                }
            }
        }

        return answer;
    }
    
    private boolean isFull(List<String> store, int cacheSize) {
        return store.size() != cacheSize;
    }
}
