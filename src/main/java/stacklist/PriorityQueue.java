package stacklist;

/**
 * Created by oleksandr on 09.07.17.
 */
public class PriorityQueue {
    private int[] array;
    private int elements;

    public PriorityQueue(int capacity) {
        this.elements = 0;
        array = new int[capacity];
    }

    public void insert(int newElement) {
        if (elements == 0) {
            array[0] = newElement;
        } else {
            int i;


            for (i = elements-1; i > 0; i--) {
                if (newElement > array[i]) {
                    array[i+1] = array[i];
                } else {
                    break;
                }
            }
            array[i] = newElement;
        }
        elements++;
    }

    public int remove() {
        return array[--elements];
    }

}
