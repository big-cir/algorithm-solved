import java.util.*;

class Solution {
    
    static int n, cardNum;
    
    public int solution(int coin, int[] cards) {
        n = cards.length;
        cardNum = n / 3;
        Set<Integer> userCard = new HashSet<>();
        Set<Integer> holdingCard = new HashSet<>();
        for (int i = 0; i < cardNum; i++) {
            userCard.add(cards[i]);
        }

        int target = n + 1;
        int answer = 0;
        while (true) {
            answer++;
            
            if (cardNum >= n) break;

            for (int i = 0; i < 2; i++) {
                int num = cards[cardNum++];
                holdingCard.add(num);
            }

            boolean canNext = false;
            for (int x : userCard) {
                if (userCard.contains(target - x)) {
                    userCard.remove(x);
                    userCard.remove(target - x);
                    canNext = true;
                    break;
                }
            }

            if (!canNext) {
                if (coin > 0) {
                    for (int x : userCard) {
                        if (holdingCard.contains(target - x)) {
                            userCard.remove(x);
                            holdingCard.remove(target - x);
                            coin--;
                            canNext = true;
                            break;
                        }
                    }
                }
            }

            if (!canNext) {
                if (coin > 1) {
                    for (int x : holdingCard) {
                        if (holdingCard.contains(target - x)) {
                            holdingCard.remove(x);
                            holdingCard.remove(target - x);
                            coin -= 2;
                            canNext = true;
                            break;
                        }
                    }
                }
            }

            if (!canNext) break;
        }

        return answer;
    }
}