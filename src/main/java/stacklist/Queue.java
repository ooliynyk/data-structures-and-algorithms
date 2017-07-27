package stacklist;

/**
 * Created by oleksandr on 09.07.17.
 */
public class Queue {
    private int[] array;
    private int front;
    private int rear;
    private int elements;

    public void insert(int newValue) {
        if (isFull()) {
            throw new RuntimeException("Queue is full!");
        }

        if (rear == array.length-1) {
            rear = -1;
        }
        elements++;
        array[++rear] = newValue;
    }

    private boolean isFull() {
        return elements == array.length;
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        int removableValue = array[front++];
        if (front == array.length) {
            front = 0;
        }
        elements--;
        return removableValue;
    }

    private boolean isEmpty() {
        return elements == 0;
    }


}
