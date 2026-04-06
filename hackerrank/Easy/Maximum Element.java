import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    
    private static Stack<Integer> dataStore;
    private static Stack<Integer> maximumStore;

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
        initStore();
        List<Integer> result = new ArrayList<>();
        
        for (String operation : operations) {
            String[] operationArr = operation.split(" ");
            int command = Integer.parseInt(operationArr[0]);
            int element;
            if (command == 1) {
                element = Integer.parseInt(operationArr[1]);
                addElement(element);
            } else if (command == 2) {
                deleteElement();
            } else {
                int printElement = printMaximumElement();
                result.add(printElement);
            }
        }
        
        return result;
    }
    
    private static void initStore() {
        dataStore = new Stack<>();
        maximumStore = new Stack<>();
    }
    
    private static void addElement(int element) {
        dataStore.push(element);
        
        if (maximumStore.isEmpty()) {
            maximumStore.push(element);
        } else {
            int max = Math.max(maximumStore.peek(), element);
            maximumStore.push(max);
        }
    }
    
    private static void deleteElement() {
        if (dataStore.isEmpty()) return;
        
        dataStore.pop();
        maximumStore.pop();
    }
    
    private static int printMaximumElement() {
        return maximumStore.peek();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
