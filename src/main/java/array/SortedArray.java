package array;

/**
 * Created by oleksandr on 29.06.17.
 */
public class SortedArray extends Array {

    public SortedArray(int size) {
        super(size);
    }

    @Override
    public void insert(Long key) {
        int position;
        for (position = 0; position < elements; position++) {
            if (key < array[position]) {
                break;
            }
        }

        for (int j = elements; j > position; j--) {
            array[j] = array[j-1];
        }
        array[position] = key;

        elements++;
    }

    @Override
    public int search(Long key) {
        int left = 0;
        int right = elements-1;
        return recursiveSearch(key, left, right);
       /* while (true) {
            int position = (left + right) / 2;
            if (key.equals(array[position])) {
                return position;
            } else if (left > right) {
                return elements;
            } else {
                if (key < array[position]) {
                    right = position + 1;
                } else if (key > array[position]) {
                    left = position + 1;
                }
            }
        }*/
    }

    private int recursiveSearch(Long key, int left, int right) {
        int position = (left + right) / 2;
        if (key.equals(array[position])) {
            return position;
        } else if (left > right) {
            return elements;
        } else {
            if (key < array[position]) {
                return recursiveSearch(key, left, position + 1);
            } else {
                return recursiveSearch(key, position + 1, right);
            }
        }
    }

    @Override
    public boolean delete(Long key) {
        int position;
        for (position = 0; position < elements; position++) {
            if (array[position].equals(key)) {
                break;
            }
        }
        if (position == elements) {
            return false;
        }

        for (int i = position; i < elements-1; i++) {
            array[i] = array[i+1];
        }
        elements--;

        return true;
    }
}
