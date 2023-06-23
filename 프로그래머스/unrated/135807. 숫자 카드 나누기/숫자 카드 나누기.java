import java.util.*;

class Solution {
    public List<Integer> get_div(int a) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                arr.add(i);
                arr.add(a / i);
            }
        }
        return arr;
    }
    public int problem(int[] arr1, int[] arr2) {
        List<Integer> div = get_div(arr1[0]);
        Collections.sort(div, Collections.reverseOrder());
        int i, j;
        boolean GCD;
        for(i = 0; i < div.size() - 1; i++) {
            GCD = false;
            int num = div.get(i); //현재 숫자
            for(j = 0; j < arr1.length; j++) {
                if(arr1[j] % num != 0)
                {
                    break;
                }
            }
            if(j == arr1.length)
            {
                GCD = true;                
            }
            if(GCD) {
                for(j = 0; j < arr2.length; j++) {
                    if(arr2[j] % num == 0)
                    {
                        break;
                    }
                }
                if(j == arr2.length)
                    return num;
            }
        }
        return 0;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int 철수;
        int 영희;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        철수 = problem(arrayA, arrayB);
        영희 = problem(arrayB, arrayA);
        answer = 철수 > 영희 ? 철수 : 영희;
        return answer;
    }
}
