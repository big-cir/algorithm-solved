import java.util.*;
class Solution {
    private static final int START = 0;
    private static final int END = 1;
    private static final int FIND = 2;

    public static int answer(int[] arrary, int[] command) {
        int returnVal = 0;
        List<Integer> tmp = new ArrayList<>();

        for (int i = command[START] - 1; i < command[END]; i++) {
            tmp.add(arrary[i]);
        }
        Collections.sort(tmp);

        returnVal = tmp.get(command[FIND] - 1);
        return returnVal;
    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            list.add(answer(array, commands[i]));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}