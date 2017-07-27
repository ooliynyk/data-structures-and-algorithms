package list;

import lombok.Data;

/**
 * Created by oleksandr on 14.07.17.
 */
public class DoublyLinkedList {
    private Link first;
    private Link last;

    public void insertFirst(Double value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(Double value) {
        Link newLink = new Link(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }

        newLink.previous = last;
        last = newLink;
    }

    public boolean insertAfter(Double key, Double value) {
        Link newLink = new Link(value);
        Link current = first;
        while (current != null) {
            if (current.getData().equals(key)) {
                if (current == last) {
                    last = newLink;
                } else {
                    current.next.previous = newLink;
                    newLink.next = current.next;
                }

                current.next = newLink;
                newLink.previous = current;

                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        if (first.next != null) {
            first.next.previous = null;
        } else {
            last = null;
        }
        first = first.next;
    }

    public void removeLast() {
        if (last.previous != null) {
            last.previous.next = null;
        } else {
            first = null;
        }
        last = last.previous;
    }

    public void displayForward() {
        Link current = first;
        while (current != null) {
            System.out.printf("%g ", current.getData());
            current = current.next;
        }
        System.out.printf("\n");
    }

    public void displayBackward() {
        Link current = last;
        while (current != null) {
            System.out.printf("%g ", current.getData());
            current = current.previous;
        }
        System.out.printf("\n");
    }

    public boolean remove(Double value) {
        Link current = first;
        while (current != null && !current.getData().equals(value)) {
            current = current.next;
        }
        if (current != null) {
            if (current == first) {
                first = current.next;
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Data
    public static class Link {
        private Double data;
        private Link next;
        private Link previous;

        public Link(Double data) {
            this.data = data;
        }
    }
}
