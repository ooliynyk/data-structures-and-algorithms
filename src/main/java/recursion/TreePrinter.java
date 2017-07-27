package recursion;

import java.util.Arrays;

public class TreePrinter {

    private int width;
    private char[] buffer;
    private int counter;

    public TreePrinter() {
    }

    public void print(int width) {
        this.width = width;
        counter = 0;
        buffer = new char[180];
        makeBranches(0, width-1);
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i]);
            if (i > 1 && (i+1) % width == 0) {
                System.out.print("\n");
            }
        }
        System.out.println(Arrays.toString(buffer));
    }

    private void makeBranches(int left, int right) {
        if (left > right)
            return;

        int branchePoint = (left + right) / 2;
        for (int i = left; i <= right; i++) {
            if (i == branchePoint) {
                buffer[counter++] = 'X';
            } else {
                buffer[counter++] = '-';
            }
        }

        if (left == right)
            return;

        makeBranches(left, branchePoint);
        makeBranches(branchePoint+1, right);
    }
}
