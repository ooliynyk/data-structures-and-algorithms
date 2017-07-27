package recursion;

public class MergeSort {

    private int[] buffer;

    public void sort(int[] array) {
        buffer = new int[array.length];
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int lower, int upper) {
        if (lower == upper) {
            return;
        } else {
            int mid = (upper + lower) / 2;
            mergeSort(array, lower, mid);
            mergeSort(array, mid + 1, upper);
            merge(array, lower, mid + 1, upper);
        }
    }

    private void merge(int[] array, int lowPtr, int highPtr, int upperBound) {
        int cCounter = 0;
        int lowerBound = lowPtr;
        int end = upperBound - lowerBound + 1;
        int mid = highPtr - 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (array[lowPtr] < array[highPtr]) {
                buffer[cCounter++] = array[lowPtr++];
            } else {
                buffer[cCounter++] = array[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            buffer[cCounter++] = array[lowPtr++];
        }
        while (highPtr <= upperBound) {
            buffer[cCounter++] = array[highPtr++];
        }
        for (int i = 0; i < end; i++) {
            array[lowerBound + i] = buffer[i];
        }
    }

}
