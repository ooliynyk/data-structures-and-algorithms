package stacklist;

import java.util.concurrent.atomic.AtomicReference;

public class ThreadSafeStack<T> {

    private AtomicReference<Node<T>> head = new AtomicReference<>();

    public T pop() {
        Node<T> newHead;
        Node<T> oldHead;
        do {
            oldHead = head.get();
            if (oldHead == null)
                throw new RuntimeException("Stack is empty!");

            newHead = oldHead.getNext();
        } while (!head.compareAndSet(oldHead, newHead));

        return oldHead.getValue();
    }

    public void push(T value) {
        Node<T> newHead = new Node<>(value);
        Node<T> oldHead;
        do {
            oldHead = head.get();
            newHead.setNext(oldHead);
        } while (!head.compareAndSet(oldHead, newHead));
    }

    public boolean isEmpty() {
        return head.get() == null;
    }

}
