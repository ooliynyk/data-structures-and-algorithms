package common;

import lombok.Data;

import java.io.PrintStream;

@Data
public class DataItem implements Comparable<DataItem> {
    private final int value;

    public DataItem(int value) {
        this.value = value;
    }

    public void display(PrintStream stream) {
        stream.printf("/%d\n", value);
    }

    @Override
    public int compareTo(DataItem o) {
        return Integer.compare(value, o.value);
    }

}
