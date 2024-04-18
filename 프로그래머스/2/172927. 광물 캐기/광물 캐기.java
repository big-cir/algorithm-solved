import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        
        backtracking(picks,minerals,0,0);
        
        return answer;
    }
    
    static void backtracking(int[] picks, String[] minerals, int res, int idx){
        boolean allPicksUsed = true;
        for(int pick : picks){
            if(pick != 0){
                allPicksUsed = false;
                break;
            }
        }
        
        if(idx == minerals.length || allPicksUsed){
            answer = Math.min(answer,res);
            return;
        }
        
        for(int i=0;i<picks.length;i++){
            int newRes = res;
            if(picks[i]==0) continue;
            
            int fin = idx+5>minerals.length ? minerals.length : idx+5;
            for(int j=idx;j<fin;j++){
                switch(i){
                    case 0:
                        newRes++;
                        break;
                    case 1:
                        if(minerals[j].equals("diamond")) newRes += 5;
                        else newRes++;
                        break;
                    case 2:
                        if(minerals[j].equals("diamond")) newRes += 25;
                        else if(minerals[j].equals("iron")) newRes += 5;
                        else newRes++;
                        break;
                }
            }
            
            picks[i]--;
            backtracking(picks,minerals,newRes,fin);
            picks[i]++;
        }
    }
}