import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            List<Integer> board = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            for (int i = 0; i < dump; i++) {
                int maxIndex = getIndexOfMax(board);
                int minIndex = getIndexOfMin(board);
                updateBoard(maxIndex, -1, board);
                updateBoard(minIndex, 1, board);
            }
            
            int findMax = board.get(getIndexOfMax(board));
            int findMin = board.get(getIndexOfMin(board));

            System.out.println("#" + tc + " " + (findMax - findMin));
        }
    }

    private static int getIndexOfMax(List<Integer> board) {
        int max = Collections.max(board);
        return board.indexOf(max);
    }

    private static int getIndexOfMin(List<Integer> board) {
        int min = Collections.min(board);
        return board.indexOf(min);
    }

    private static void updateBoard(int index, int updateValue, List<Integer> board) {
        board.set(index, board.get(index) + updateValue);
    }
}
