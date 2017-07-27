package complexSort;

public class ShellSort {

    public void sort(int[] array) {
        int h = 1;
        while (true) {
            int next = 3 * h + 1;
            if (next > array.length) {
                break;
            }
            h = next;
        }

        while (h > 0) {
            for (int out = h; out < array.length; out++) {
                int next = array[out];
                int inner = out - 1;
                while (inner > h - 1 && array[inner - h] > next) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = next;
            }
            h = (h - 1) / 3;
        }

    }

}
