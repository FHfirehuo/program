package datastructure.sequence;


public interface FireVector<E> {

    boolean isEmpty();

    int size();

    void add(E e);

    void set(int index, E e);

    E get(int index);

    void remove(int index);

    boolean contains(E e);

}
