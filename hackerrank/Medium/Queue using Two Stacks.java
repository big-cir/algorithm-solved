import java.io.*;
import java.util.*;

class SolutionQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;
    
    public SolutionQueue(int capacity) {
        inStack = new ArrayDeque<>(capacity);
        outStack = new ArrayDeque<>(capacity);
    }
    
    public void enqueue(int element) {
        inStack.push(element);
    }
    
    public void dequeue() {
        moveElement();
        outStack.pop();
    }
    
    public int printElement() {
        moveElement();
        return outStack.peek();
    }
    
    private void moveElement() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queryCount = Integer.parseInt(br.readLine());
        SolutionQueue queue = new SolutionQueue(queryCount);
        
        for (int i = 0; i < queryCount; i++) {
            String query = br.readLine();
            String[] queryArr = query.split(" ");
            int command = Integer.parseInt(queryArr[0]);
            
            switch (command) {
                case 1 -> {
                    int element = Integer.parseInt(queryArr[1]);
                    queue.enqueue(element);
                }
                case 2 -> queue.dequeue();
                case 3 -> {
                    int printElement = queue.printElement();
                    System.out.println(printElement);
                }
            }
            
        }
    }
}
