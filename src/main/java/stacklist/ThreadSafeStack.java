package stacklist;

public class ThreadSafeStack<T> {

    private Node<T> head;

    public T pop() {
        if (head == null)
            throw new RuntimeException("Stack is empty!");

        Node<T> next = head;
        head = head.getNext();

        return next.getValue();
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
