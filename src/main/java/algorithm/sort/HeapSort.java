package algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(HeapSort.heapSort(array)));

    }

    private static int[] heapSort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        buildMaxHeap(array, length);

        System.out.println("大顶堆：" + Arrays.toString(array));

        while (length > 1) {
            int temp = array[0];
            array[0] = array[length - 1];
            array[length - 1] = temp;
            length--;
            popBuildMaxHeap(array, length);
        }

        return array;
    }

    private static void popBuildMaxHeap(int[] array, int length) {
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
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

    /**
     * 建立最大堆
     *
     * @param array
     * @param length
     */
    private static void buildMaxHeap(int[] array, int length) {

        for (int i = 0; i < length / 2; i++) {
            downAdjustHeap(array, i, length);
        }
    }

    /**
     * 通过下沉初始化一个无序数组为大顶堆
     *
     * @param array
     * @param parentIndex
     */
    private static void downAdjustHeap(int[] array, int parentIndex, int length) {
        int childIndex = 2 * parentIndex + 1;
        if (childIndex + 1 < length && array[childIndex] < array[childIndex + 1]) {
            childIndex++;
        }
        if (array[childIndex] > array[parentIndex]) {
            int temp = array[parentIndex];
            array[parentIndex] = array[childIndex];
            array[childIndex] = temp;
        }
    }

}
