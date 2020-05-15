package datastructure.queue;

import java.util.Arrays;

/**
 * 小顶优先队列
 */
public class MinPriorityQueue {
    private int size = 0;
    private int[] array;

    public MinPriorityQueue() {
        array = new int[32];
    }

    public MinPriorityQueue(int size) {
        array = new int[size];
    }

    public MinPriorityQueue(int[] array) {
        this.size = array.length;
        this.array = array;
        synchronized (this.array) {

        }


    }

    public void add(int element) {

        if (size >= array.length) {
            System.out.println("resize");
            resize();
            System.out.println("resize over");
        }

        array[size++] = element;
        upAdjust();
    }

    public int pop() {

        if (size < 1) {
            throw new RuntimeException("the queue is empty!");
        }

        int head = array[0];
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    private void downAdjust() {

    }

    private void upAdjust() {

    }

    private void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public int size() {
        return this.size;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};

        System.out.println("原始数组：" + Arrays.toString(array));
        MinPriorityQueue queue = new MinPriorityQueue(array);
        System.out.println("准备添加");
        queue.add(14);
        queue.add(11);
        queue.add(20);
        queue.add(12);
        System.out.println("添加完");

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.pop());
        }

    }

}
