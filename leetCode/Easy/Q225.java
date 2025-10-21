// sol1
class MyStack {
    
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int pop = q1.poll();

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

        return pop;
    }
    
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int top = q1.poll();
        q2.offer(top);

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

// sol2
class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

// sol3
class MyStack {

    private Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = q1.size();
        q1.offer(x);
        while (size > 0) {
            q1.offer(q1.poll());
            size--;
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
