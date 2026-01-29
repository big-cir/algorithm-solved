// 시간복잡도: O(1)
class MyCircularQueue {

    private int[] store;
    private int front, rear, element;

    public MyCircularQueue(int k) {
        store = new int[k];
        front = 0;
        rear = 0;
        element = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        store[rear] = value;
        rear = (rear + 1) % store.length;
        element++;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % store.length;
        element--;

        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;

        return store[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;

        int lastElementIndex = (rear - 1 + store.length) % store.length;
        return store[lastElementIndex];
    }
    
    public boolean isEmpty() {
        return element == 0;
    }
    
    public boolean isFull() {
        return element == store.length;
    }
}

// 시간복잡도: O(N log N)
class MyCircularQueue {

    private int[] store;
    private int front, rear;

    public MyCircularQueue(int k) {
        store = new int[k];
        Arrays.fill(store, -1);
        front = 0;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % store.length;
        store[rear] = value;

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        store[front] = -1;
        front = (front + 1) % store.length;

        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;

        return store[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;

        return store[rear];
    }
    
    public boolean isEmpty() {
        boolean flag = true;
        for (int i = 0; i < store.length; i++) {
            if (store[i] >= 0){
                flag = false;
                break;
            }
        }

        return flag;
    }
    
    public boolean isFull() {
        boolean flag = true;
        for (int i = 0; i < store.length; i++) {
            if (store[i] < 0){
                flag = false;
                break;
            }
        }

        return flag;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
