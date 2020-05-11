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

        return array;
    }
}
