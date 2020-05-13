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
            buildMaxHeap(array, length);
        }


        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     * @param length
     */
    private static void buildMaxHeap(int[] array, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, length);
        }
    }

    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        int parentIndex = i;
        int chaildIndex = 2 * parentIndex + 1;
        while (chaildIndex < length) {

            if (chaildIndex + 1 < length && array[chaildIndex] < array[chaildIndex + 1]) {
                //右叶子比较大
                chaildIndex++;
            }
            if (temp < array[chaildIndex]) {
                array[parentIndex] = array[chaildIndex];
                parentIndex = chaildIndex;
                chaildIndex = 2 * parentIndex + 1;
            }else {
                break;
            }
        }

        array[parentIndex] = temp;
    }
}
