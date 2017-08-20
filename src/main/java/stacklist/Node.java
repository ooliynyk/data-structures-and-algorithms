package stacklist;

import lombok.Data;

@Data
public class Node<T> {

    private Node next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

}
