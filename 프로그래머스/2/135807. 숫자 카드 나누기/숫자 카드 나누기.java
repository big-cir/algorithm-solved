import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(pro(arrayA, arrayB), pro(arrayB, arrayA));
    }
    
    private int pro(int[] arr1, int[] arr2) {
        int tmp = 0;
        for (int num : getDivNum(arr1)) {
            boolean flag = true;
            int val = 0;
            for (int i = 0; i < arr2.length; i++) {
                val = arr2[i];
                
                if (val % num == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) tmp = Math.max(tmp, num);
        }
        return tmp;
    }
    
    private List<Integer> getDivNum(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = arr[0];
        
        for (int i = 1; i <= min; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) list.add(i);
        }
        
        return list;
    }
}