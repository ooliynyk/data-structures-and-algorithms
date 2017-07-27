package recursion;

/**
 * Created by oleksandr on 19.07.17.
 */
public class AnagramCreator {
    private char[] input;
    private int count;

    public AnagramCreator(String text) {
        this.input = text.toCharArray();
    }

    public void make(int size) {
        if (size == 1)
            return;

        for (int i = 0; i < size; i++) {
            make(size-1);
            if (size == 2) {
                displayWord();
            }
            rotate(size);
        }
    }

    private void displayWord() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        System.out.print("   ");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println("");
        }
    }

    private void rotate(int newSize) {
        int position = input.length - newSize;
        char tmp = input[position];
        int i;
        for (i = position+1; i < input.length; i++) {
            input[i-1] = input[i];
        }
        input[i-1] = tmp;
    }

}
