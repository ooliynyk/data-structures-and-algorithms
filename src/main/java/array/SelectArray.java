package array;

/**
 * Created by oleksandr on 30.06.17.
 */
public class SelectArray extends Array implements IArray<Long> {
    public SelectArray(int size) {
        super(size);
    }

    @Override
    public void sort() {
        for (int out = 0; out < elements-1; out++) {
            int smallestElementIndex = out;
            for (int i = out+1; i < elements; i++) {
                if (array[i] < array[smallestElementIndex]) {
                    smallestElementIndex = i;
                }
            }
            swap(out, smallestElementIndex);
        }
    }

}
