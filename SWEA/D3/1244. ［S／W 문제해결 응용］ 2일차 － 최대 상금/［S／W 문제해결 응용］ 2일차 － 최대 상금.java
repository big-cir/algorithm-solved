
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {

    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int l = 1;  l <= tc; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] numbers = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            int Level = Integer.parseInt(st.nextToken());
            
            if (Level > numbers.length) {
                Level = numbers.length;
            }

            max = Integer.MIN_VALUE;
            backTracking(numbers, Level, 0, 0);

            System.out.println("#" + l + " " + max);
        }
    }

    private static void backTracking(int[] numbers, int Level, int count, int startIdx) {
        int[] copyArr = numbers.clone();
        if (count == Level) {
            max = Math.max(max, toInteger(numbers));
            return;
        }

        for (int i = startIdx; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(copyArr, i, j);
                backTracking(copyArr, Level, count + 1, i);
                swap(copyArr, i, j);
            }
        }
    }

    private static void swap(int[] copyArr, int index1, int index2) {
        int tmp = copyArr[index1];
        copyArr[index1] = copyArr[index2];
        copyArr[index2] = tmp;
    }

    private static int toInteger(int[] number) {
        String toInt = "";
        for (int x : number) {
            toInt += x;
        }
        return Integer.parseInt(toInt);
    }
}
