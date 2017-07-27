package array;

/**
 * Created by oleksandr on 30.06.17.
 */
public class BubbleArray extends Array {

    public BubbleArray(int size) {
        super(size);
    }

    @Override
    public void sort() {
        for (int i = elements - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swap(j, j+1);
                }
            }
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    swap(j, j-1);
                }
            }
        }
    }

}
