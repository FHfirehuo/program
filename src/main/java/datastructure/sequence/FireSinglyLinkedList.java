package datastructure.sequence;

/**
 * 单向链表
 */
public class FireSinglyLinkedList<E> {

    int size = 0;
    Node<E> first;
    Node<E> last;

    public FireSinglyLinkedList() {

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(E e) {
        Node<E> p = this.last;
        Node<E> newNode = new Node<>(e, null);
        this.last = newNode;

        if (p == null) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }

        this.size++;
    }

    public void add(int index, E e) {
        checkPositionInde(index);
        if (index == size) {
            add(e);
        } else if (index == 0) {
            Node<E> newNode = new Node<>(e, null);
            newNode.next = first;
            this.first = newNode;
            this.size++;
        } else {
            Node<E> pre = node(index - 1);
            Node<E> newNode = new Node<>(e, null);
            Node<E> x = pre.next;
            pre.next = newNode;
            newNode.next = x;
            this.size++;
        }
    }

    private void checkPositionInde(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= this.size;
    }

    public void set(int index, E e) {

        Node<E> x = node(index);
        x.item = e;
    }

    private Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = first.next;
        }
        return x;
    }

    public E get(int index) {
        return node(index).item;
    }

    public void remove(int index) {
        if (index == 0) {
            Node<E> head = first;
            this.first = first.next;
            head.next = null;
            //last = null;
        } else {
            Node<E> pre = node(index - 1);
            Node<E> x = pre.next;
            Node<E> next = x.next;
            pre.next = next;
            x.next = null;
        }

        size--;

        if (this.size == 0) {
            this.last = null;
        }
    }

    private class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
