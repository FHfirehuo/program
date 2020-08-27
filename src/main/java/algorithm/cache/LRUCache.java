package algorithm.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU，最近最少使用，把数据加入一个链表中，按访问时间排序，发生淘汰的时候，把访问时间最旧的淘汰掉。<br>
 * <p>
 * 比如有数据 1，2，1，3，2<br>
 * 此时缓存中已有（1，2）<br>
 * 当3加入的时候，得把后面的2淘汰，变成（3，1）<br>
 * 显然<br>
 * LRU对于循环出现的数据，缓存命中不高<br>
 * 比如，这样的数据，1，1，1，2，2，2，3，4，1，1，1，2，2，2.....<br>
 * 当走到3，4的时候，1，2会被淘汰掉，但是后面还有很多1，2
 */
public class LRUCache<E> {


    private Map<Object, DoublyLinkedNode<E>> data;
    //容量
    private int capacity;

    private DoublyLinkedNode<E> head;
    private DoublyLinkedNode<E> tail;

    public LRUCache() {
        this(10);
    }

    public LRUCache(int capacity) {
        data = new HashMap<>(capacity, 1);
        this.capacity = capacity;
    }

    public int Size() {
        return this.data.size();
    }

    public void put(Object key, E element) {

        DoublyLinkedNode<E> newNode = new DoublyLinkedNode();
        newNode.key = key;
        newNode.element = element;

        if (this.data.containsKey(key)) {
            DoublyLinkedNode<E> oldNode = this.data.get(key);
            this.remove(key, oldNode);
        }

        if (data.size() == this.capacity) {
            removeFail();
        }

        this.add(key, newNode);
        if (data.size() == 1) {
            this.head = newNode;
            this.tail = newNode;
            this.head.next = this.tail;
            this.tail.pre = this.head;
        }


    }

    private void removeFail() {
        DoublyLinkedNode<E> item = this.tail;
        this.tail = item.pre;
        data.remove(item.key);
    }

    private void add(Object key, DoublyLinkedNode<E> item) {
        item.next = this.head;
        if (this.head != null) {
            this.head.pre = item;
        }
        this.head = item;
        data.put(key, item);
    }

    private void remove(Object key, DoublyLinkedNode<E> item) {

        if (item.equals(this.tail)){
            this.tail = item.pre;
        }

        if (item.pre != null) {
            item.pre.next = item.next;
        }
        if (item.next != null) {
            item.next.pre = item.pre;
        }


        data.remove(key);
    }

    public E get(Object key) {
        if (!data.containsKey(key)) {
            return null;
        }
        DoublyLinkedNode<E> item = data.get(key);
        this.remove(key, item);
        this.add(key, item);
        return item.element;
    }

    private class DoublyLinkedNode<E> {
        Object key;
        E element;
        DoublyLinkedNode pre;
        DoublyLinkedNode next;
    }

    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get 1 = " + cache.get(1));
        System.out.println("add 3");
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println("get 2 = " + cache.get(2));
        System.out.println("add 4");
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println("get 3 = " + cache.get(3));
        System.out.println("get 4 = " + cache.get(4));
        System.out.println("get 1 = " + cache.get(1));

        LinkedHashMap<String, String> a = new LinkedHashMap();
        a.put("1", "1");

    }

}
