package stacklist;

/**
 * Created by oleksandr on 09.07.17.
 */
public class PriorityQueue<T extends Comparable> {
    private T[] array;
    private int elements;

    public PriorityQueue(int capacity) {
        this.elements = 0;
        array = (T[]) new Comparable[capacity];
    }

    public void insert(T newElement) {
        if (elements == 0) {
            array[0] = newElement;
        } else {
            int i;


            for (i = elements - 1; i >= 0; i--) {
                if (newElement.compareTo(array[i]) < 0) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = newElement;
        }
        elements++;
    }

    public T remove() {
        return array[--elements];
    }

    public int size() {
        return elements;
    }

}
