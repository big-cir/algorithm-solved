// Simple
// - push O(n), pop O(1), peek O(1)
class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack.push(x);

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

// Lazy
// - push O(1), pop/peek Amortized O(1)
class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        inToOut();
        return outStack.pop();
    }
    
    public int peek() {
        inToOut();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void inToOut() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}

// LinkedList: O(1)
class MyQueue {

    private LinkedList<Integer> list;

    public MyQueue() {
        list = new LinkedList<>();
    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public int pop() {
        return list.removeFirst();
    }
    
    public int peek() {
        return list.peekFirst();
    }
    
    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
