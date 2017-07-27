package list;

import lombok.Data;

/**
 * Created by oleksandr on 11.07.17.
 */
public class List {

    private Link first;
    private Link last;

    public List(Link[] array) {
        for (Link link : array) {
            insert(link.getValue(), link.getDValue());
        }
    }

    public List() {

    }

    public void insert(int value, double dValue) {
        Link link = new Link(value, dValue);

        Link currentLink = first;
        Link previousLink = null;

        while (currentLink != null && currentLink.getValue() < link.getValue()) {
            previousLink = currentLink;
            currentLink = currentLink.next;
        }

        if (previousLink != null) {
            previousLink.next = link;
            link.next = currentLink;
        } else {
            link.next = first;
            first = link;
        }

    }

    public void insertLast(int value, double dValue) {
        Link link = new Link(value, dValue);
        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }
        last = link;
    }

    public Link deleteFirst() {
        Link removable = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return removable;
    }

    public Link find(int key) {
        Link currentLink = first;
        while (currentLink != null && currentLink.getValue() != key) {
            currentLink = currentLink.next;
        }
        return currentLink;
    }

    public Link delete(int key) {
        Link currentLink = first;
        Link previousLink = first;
        while (currentLink.getValue() != key) {
            if (currentLink == null) {
                return null;
            }
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        if (currentLink == first) {
            deleteFirst();
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void display() {
        Link currentLink = first;
        while (currentLink != null) {
            currentLink.display();
            currentLink = currentLink.next;
        }
    }

    public Link remove() {
        Link removable = first;
        first = first.next;
        return removable;
    }

    public Iterator iterator() {
        return new Iterator(this);
    }

    @Data
    public static class Link {
        private int value;
        private double dValue;

        private Link next;

        public Link(int value, double dValue) {
            this.value = value;
            this.dValue = dValue;
        }

        public void display() {
            System.out.printf("{%d, %f}\n", value, dValue);
        }

        @Override
        public String toString() {
            return "Link{" +
                    "value=" + value +
                    ", dValue=" + dValue +
                    '}';
        }
    }

    public static class Iterator {
        private List list;
        private Link current;
        private Link previous;

        public Iterator(List list) {
            this.list = list;
        }

        public void reset() {
            previous = null;
            current = list.first;
        }

        public Link current() {
            return current;
        }

        public void nextLink() {
            previous = current;
            current = current.next;
        }

        public void insertAfter(Link link) {
            if (list.isEmpty()) {
                list.first = link;
                current = link;
            } else {
                link.next = current.next;
                current.next = link;
                nextLink();
            }
        }

        public void insertBefore(Link link) {
            if (previous == null) {
                link.next = list.first;
                list.first = link;
                reset();
            } else {
                link.next = previous.next;
                previous.next = link;
                current = link;
            }
        }

        public void deleteCurrent() {
            previous.next = current.next;
            current = current.next;
        }

        public boolean atEnd() {
            return current == null;
        }

    }

}
