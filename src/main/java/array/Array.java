package array;

import lombok.ToString;

/**
 * Created by oleksandr on 29.06.17.
 */
@ToString
public class Array implements IArray<Long> {
    protected Long[] array;
    protected int elements;

    public Array(int size) {
        this.array = new Long[size];
        this.elements = 0;
    }

    public void insert(Long key) {
        array[elements++] = key;
    }

    public int size() {
        return elements;
    }

    @Override
    public void sort() {

    }

    public boolean delete(Long key) {
        int index = search(key);
        boolean found = index != -1;
        if (!found)
            return false;

        elements--;
        for (int i = index; i < elements; i++) {
            array[i] = array[i+1];
        }

        return delete(key);
    }

    public int search(Long key) {
        int index = -1;
        for (int i = 0; i < elements; i++) {
            if (array[i].equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }


    protected void swap(int left, int right) {
        long temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
