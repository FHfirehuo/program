package datastructure.queue;

import java.util.Arrays;

/**
 * 大顶优先队列
 */
public class MaxPriorityQueue {
    private int size = 0;
    private int[] array;

    public MaxPriorityQueue() {
        array = new int[32];
    }

    public MaxPriorityQueue(int size) {
        array = new int[size];
    }

    public MaxPriorityQueue(int[] array) {
        this.size = array.length;
        this.array = array;
        synchronized (this.array) {

            for (int parentIndex = 0; parentIndex < this.size / 2; parentIndex++) {
                int childIndex = 2 * parentIndex + 1;
                if (childIndex + 1 < this.size && array[childIndex] < array[childIndex + 1]) {
                    childIndex++;
                }
                if (array[childIndex] > array[parentIndex]) {
                    int temp = array[parentIndex];
                    array[parentIndex] = array[childIndex];
                    array[childIndex] = temp;
                }
            }
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
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < this.size) {
            if (childIndex + 1 < this.size && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            if (array[childIndex] > temp) {

                array[parentIndex] = array[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * parentIndex + 1;
            } else {
                break;
            }
        }
        array[parentIndex] = temp;
    }

    private void upAdjust() {
        int childIndex = this.size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = this.array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        this.array[childIndex] = temp;
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
        MaxPriorityQueue queue = new MaxPriorityQueue(array);
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
