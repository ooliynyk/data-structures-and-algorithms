package array;

/**
 * Created by oleksandr on 29.06.17.
 */
public class DataArray {
    private Person[] array;
    private int elements;

    public DataArray(int size) {
        this.array = new Person[size];
        this.elements = 0;
    }

    public boolean delete(String searchName) {
        int position;
        for (position = 0; position < elements; position++) {
            String currentKey = array[position].getLastName();
            if (currentKey.equals(searchName)) {
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

    public int search(String searchName) {
        int left = 0;
        int right = elements-1;

        while (true) {
            int position = (left + right) / 2;
            String currentKey = array[position].getLastName();
            if (searchName.equals(currentKey)) {
                return position;
            } else if (left > right) {
                return elements;
            } else {
                if (searchName.compareTo(currentKey) < 0) {
                    right = position + 1;
                } else if (searchName.compareTo(currentKey) > 0) {
                    left = position + 1;
                }
            }
        }
    }

    public void insert(Person person) {
        int position;
        String key = person.getLastName();
        for (position = 0; position < elements; position++) {
            String currentKey = array[position].getLastName();
            if (key.compareTo(currentKey) < 0) {
                break;
            }
        }

        for (int j = elements; j > position; j--) {
            array[j] = array[j-1];
        }
        array[position] = person;

        elements++;
    }

    public int size() {
        return elements;
    }
}
