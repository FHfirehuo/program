package datastructure.sequence;

/**
 * 双向链表
 */
public class FireDoublyLinkedList<E> {

    int size = 0;
    Node<E> first;
    Node<E> last;

    public FireDoublyLinkedList() {

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(E e) {
        Node<E> p = this.last;
        Node<E> newNode = new Node<>(e, null, null);
        this.last = newNode;

        if (p == null) {
            this.first = newNode;
        } else {
            p.next = newNode;
            newNode.prev = p;
        }

        this.size++;
    }

    public void add(int index, E e) {
        checkPositionInde(index);
        if (index == size) {
            add(e);
        } else if (index == 0) {
            Node<E> newNode = new Node<>(e, null, null);
            newNode.next = first;
            this.first = newNode;
        } else {
            Node<E> pre = node(index - 1);
            Node<E> newNode = new Node<>(e, null, null);
            Node<E> x = pre.next;
            pre.next = newNode;
            newNode.next = x;
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

        if (index < (size << 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = first.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = last.prev;
            }
            return x;
        }

    }

    public E get(int index) {
        return node(index).item;
    }

    public void remove(int index) {
        if (index == 0) {
            first = null;
            last = null;
        } else {
            Node<E> pre = node(index - 1);
            Node<E> x = pre.next;
            Node<E> next = x.next;
            pre.next = next;
            x.next = null;
        }

        size--;

    }


    private class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
