package tree234;

import lombok.Data;

import java.io.PrintStream;

@Data
public class DataItem implements Comparable<DataItem> {
    private final long value;

    public DataItem(long value) {
        this.value = value;
    }

    public void display(PrintStream stream) {
        stream.printf("/%d\n", value);
    }

    @Override
    public int compareTo(DataItem o) {
        return Long.compare(value, o.value);
    }

}
