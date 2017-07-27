package array;

import lombok.ToString;

/**
 * Created by oleksandr on 01.07.17.
 */
@ToString(callSuper = true)
public class InsertSort extends Array {

    public InsertSort(int size) {
        super(size);
    }

    @Override
    public void sort() {
        for (int i = 1; i < elements; i++) {
            long next = array[i];
            int j;
            int cmp;
            for (j = i; j > 0 && !((cmp = array[j-1].compareTo(next)) < 0); j--) {
                if (cmp > 0) {
                    array[j] = array[j-1];
                } else if (cmp == 0) {
                    array[j-1] = -1L;
                }
            }
            array[j] = next;
        }
    }

    public long median() {
        long summ = 0;
        for (int i = 0; i < elements; i++) {
            summ += array[i];
        }
        return summ / elements;
    }

    public void noDups() {
        boolean[] dups = new boolean[elements];
        for (int out = 0; out < elements; out++) {
            Long current = array[out];
            for (int in = out+1; in < elements; in++) {
                if (array[in].equals(current)) {
                    dups[in] = true;
                }
            }
        }

        int shift = 0;
        for (int out = 1; out < elements; out++) {
            if (!dups[out]) {
                if (shift != 0) {
                    array[out - shift] = array[out];
                }

            } else {
                shift++;
            }
        }
        for (int i = elements - 1; i > elements - shift - 1; i--) {
            array[i] = null;
        }
    }

}
