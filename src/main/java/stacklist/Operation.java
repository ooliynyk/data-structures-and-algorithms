package stacklist;

/**
 * Created by oleksandr on 06.07.17.
 */
public enum Operation {
    ADD(0), SUB(0), DIV(1), MUL(1);

    private final int priority;

    Operation(int priority) {
        this.priority=priority;
    }

}
