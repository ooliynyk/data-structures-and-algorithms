package heap;

public class Heap<T extends Comparable<T>> {

    private T[] heapArray;
    private int size;

    public Heap(int capacity) {
        heapArray = (T[]) new Comparable[capacity];
        size = 0;
    }

    public void insert(T item) {
        heapArray[size] = item;
        trickleUp(size++);
    }

    private void trickleUp(int position) {
        T value = heapArray[position];
        int parent = (position - 1) / 2;
        while (parent > 0 && value.compareTo(heapArray[parent]) > 0) {
            heapArray[position] = heapArray[parent];

            position = parent;
            parent = (position - 1) / 2;
        }
        heapArray[position] = value;
    }

    public T remove() {
        T removable = heapArray[0];
        heapArray[0] = heapArray[--size];
        trickleDown(0);
        return removable;
    }

    private void trickleDown(int position) {
        T top = heapArray[position];
        while (position < size-1) {
            int leftChild = 2 * position + 1;
            int rightChild = 2 * position + 2;
            int next;
            if (rightChild < size && heapArray[leftChild].compareTo(heapArray[rightChild]) > 0) {
                next = leftChild;
            } else {
                next = rightChild;
            }
            if (top.compareTo(heapArray[next]) > 0) {
                break;
            }
            heapArray[position] = heapArray[next];
            position = next;
        }
        heapArray[position] = top;
    }

    public void change(int position, T newValue) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
        T oldValue = heapArray[position];
        heapArray[position] = newValue;
        if (newValue.compareTo(oldValue) > 0) {
            trickleUp(position);
        } else {
            trickleDown(position);
        }
    }

}
