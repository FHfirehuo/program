package datastructure.heap;

import java.util.Arrays;

public class BinaryHeap {

    //总容量
    private int size;
    private int[] heap;

    private BinaryHeap() {

    }

    public BinaryHeap(int size) {
        heap = new int[size];
    }

    public static BinaryHeap build(int[] array) {
        BinaryHeap self = new BinaryHeap(array.length);
        self.handld(array);
        return self;
    }

    private void handld(int[] array) {
        this.heap = array.clone();
//        for (int i = heap.length - 1; i > 0; i--) {
//            downAdjust(heap, i, heap.length - 1);
//        }

        for (int i = heap.length - 1; i > 0; i--) {
            upAdjust(heap, i);
        }


    }

    private void upAdjust(int[] array, int childIndex) {
        // temp保存子节点值，用于最后的赋值
        int temp = array[childIndex];
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }


    /**
     * 下沉调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    private void downAdjust(int[] array, int parentIndex, int length) {

        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {

            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
                childIndex++;
            }

            if (temp <= array[childIndex]) {
                // 如果父节点小于任何一个孩子的值，直接跳出
                break;
            }

            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        BinaryHeap bh = BinaryHeap.build(array);
        System.out.println("原数据：" + Arrays.toString(array));
        System.out.println("新数据：" + bh.toString());

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        bh = BinaryHeap.build(array);
        System.out.println("原数据：" + Arrays.toString(array));
        System.out.println("新数据：" + bh.toString());
    }

    //    public static BinaryHeap buildBigTopHeap(int[] array){
//        BinaryHeap self = new BinaryHeap(array.length);
//
//        return self;
//    }
//
//    public static BinaryHeap buildSmallTopHeap(int[] array){
//        BinaryHeap self = new BinaryHeap(array.length);
//
//        return self;
//    }
}
