package tree234;

import java.io.PrintStream;

public class DataItem {
    long value;

    public void display(PrintStream stream) {
        stream.printf("/%d\n", value);
    }

}
