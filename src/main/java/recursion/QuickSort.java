package recursion;

import java.util.Arrays;

public class QuickSort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int left, int right) {
        if (right - left <= 0)
            return;
        int pivot = array[right];
        int pivotPtr = partition(left, right, pivot);
        quickSort(left, pivotPtr - 1);

        quickSort(pivotPtr + 1, right);
    }

    public int partition(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (array[++leftPtr] < pivot)
                ;
            while (rightPtr > 0 && array[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int leftPtr, int rightPtr) {
        int tmp = array[leftPtr];
        array[leftPtr] = array[rightPtr];
        array[rightPtr] = tmp;
    }

}
