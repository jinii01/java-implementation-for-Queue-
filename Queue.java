public class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor to initialize the queue
    public Queue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int item = queue[front];
        front = (front + 1) % capacity;
        count--;

        return item;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return count == capacity;
    }

    // Method to get the size of the queue
    public int size() {
        return count;
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        q.display();

        q.dequeue();
        q.dequeue();

        q.display();

        q.enqueue(6);
        q.enqueue(7);

        q.display();
    }
}
