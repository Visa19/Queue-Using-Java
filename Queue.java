public class Queue1 {
private int capacity;
private int front;
private int rear;
private int[] array;
  
public Queue1(int capacity) {
this.capacity = capacity;
this.front = -1;
this.rear = -1;
this.array = new int[capacity];
}  
public boolean isEmpty() {
return front == -1;
}
public boolean isFull() {
return (rear + 1) % capacity == front;
}

public void enqueue(int item) {
if (isFull()) {
System.out.println("Queue is full. Cannot enqueue.");
} else {
if (isEmpty()) {
front = rear = 0;
} else {
rear = (rear + 1) % capacity;
}
array[rear] = item;
System.out.println("Enqueued: " + item);
}
}

public int dequeue() {
if (isEmpty()) {
System.out.println("Queue is empty. Cannot dequeue.");
return -1;
} else {
int item = array[front];
if (front == rear) {
front = rear = -1;
} else {
front = (front + 1) % capacity;
}
System.out.println("Dequeued: " + item);
return item;
}
}

public int peek() {
if (isEmpty()) {
System.out.println("Queue is empty.");
return -1;
} else {
return array[front];
}
}
  public void display() {
if (isEmpty()) {
System.out.println("Queue is empty.");
} else {
System.out.print("Queue: ");
int current = front;
while (current != rear) {
System.out.print(array[current] + " <- ");
current = (current + 1) % capacity;
}
System.out.println(array[current]);
}
}
  public static void main(String[] args) {
Queue1 queue = new Queue1(5);
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.display();
queue.dequeue();
queue.display();
queue.enqueue(4);
queue.enqueue(5);
queue.enqueue(6);
}
}
