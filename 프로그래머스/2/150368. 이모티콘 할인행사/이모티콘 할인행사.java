import java.util.*;

class Solution {
    
    static int[] discountList = {10, 20, 30, 40};
    static List<int[]> answer;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new ArrayList<>();

        dfs(0, users, emoticons, new int[emoticons.length]);
        answer.add(new int[] {0, 0});

        Collections.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });

        return answer.get(0);
    }

    private void dfs(int level, int[][] users, int[] emoticons, int[] emoDiscountList) {
        if (level == emoticons.length) {
            int emoticonPlus = 0;
            int cost = 0;

            for (int i = 0; i < users.length; i++) {
                int[] userInfo = users[i];
                int limitDiscount = userInfo[0];
                int limitCost = userInfo[1];

                int sumCost = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (limitDiscount > emoDiscountList[j]) continue;

                    int emoticonPrice = emoticons[j];
                    double discountPercent = (100 - emoDiscountList[j]) / 100.0;
                    int price = (int) Math.round(emoticonPrice * discountPercent);
                    sumCost += price;
                }

                if (sumCost >= limitCost) emoticonPlus++;
                else cost += sumCost;
            }

            answer.add(new int[] {emoticonPlus, cost});
            return;
        }

        for (int i = 0; i < discountList.length; i++) {
            emoDiscountList[level] = discountList[i];
            dfs(level + 1, users, emoticons, emoDiscountList);
        }
    }
}