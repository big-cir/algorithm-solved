class Solution {
    public int solution(int num) {
        int answer = 0;    
        while (num != 1) {
            System.out.println(num);
            if (isEven(num)) {
                num /= 2;
                answer++;
                continue;
            }
            if (isOdd(num)) {
                num = num * 3 + 1;
            }
            answer++;
            
            if (answer > 500) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
    
    private boolean isEven(int number) {
        if (number % 2 == 0) return true;
        return false;
    }
    
    private boolean isOdd(int number) {
        if (number % 2 == 1) return true;
        return false;
    }
}