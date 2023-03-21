import java.util.HashSet;
import java.util.Set;
class Solution {
    static boolean[] isUsed;

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void makeAllCase(int number, int[] numbers, Set<Integer> set) {
        if (isPrime(number)) set.add(number);

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) continue;

            int next = number * 10 + numbers[i];
            isUsed[i] = true;

            makeAllCase(next, numbers, set);
            isUsed[i] = false;
        }
    }
    
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        isUsed = new boolean[numbers.length()];
        int[] nums = numbers.chars().map(c -> c - '0').toArray();
        makeAllCase(0, nums, set);
        
        return set.size();
    }
}