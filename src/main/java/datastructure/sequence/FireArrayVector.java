package datastructure.sequence;

import java.util.Arrays;

public class FireArrayVector<E> implements FireVector<E> {

    private Object[] elementData;

    private int elementCount;

    private int capacityIncrement;

    protected int modCount;

    /**
     *
     * @param initialCapacity 初始容量
     * @param capacityIncrement 扩容时增长的容量
     */
    public FireArrayVector(int initialCapacity, int capacityIncrement) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal capacity " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public FireArrayVector(int initialCapacity) {
        this(initialCapacity, 0);
    }


    public FireArrayVector() {
        this(10);
    }


    @Override
    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    @Override
    public int size() {
        return this.elementCount;
    }

    @Override
    public void add(E element) {
        elementCount ++;
        capacityHelper(elementCount);
        elementData[elementCount] = element;
    }

    private void capacityHelper(int minLength) {
        if(minLength > elementData.length){
            grow(minLength);
        }
    }

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in  OutOfMemoryError: Requested array size exceeds VM limit
     *
     * 要分配的最大数组大小。 一些虚拟机在数组中保留一些头字。
     * 尝试分配更大的阵列可能会导致OutOfMemoryError：请求的阵列大小超出VM限制
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity= oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);

        if(minCapacity - newCapacity > 0){
            newCapacity = minCapacity;
        }
        if (newCapacity > MAX_ARRAY_SIZE){

        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public void set(int index, E element) {
        if (index >= elementCount){
            throw new ArrayIndexOutOfBoundsException();
        }

        elementData[index] = element;
    }

    @Override
    public E get(int index) {
        if (index >= elementCount){
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    @Override
    public void remove(int index) {
        if(index < 0){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > elementCount){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, j);
        elementData[--elementCount] = null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elementCount; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elementCount; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }

        return -1;
    }
}
