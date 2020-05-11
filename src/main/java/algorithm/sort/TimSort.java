package algorithm.sort;

import java.util.Arrays;

/**
 * TimSort 是java中Arrays.sort()采用了一种归并排序（MergeSort）的优化版本
 */
public class TimSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(TimSort.timSort(array)));
    }

    private static int[] timSort(int[] array) {

        int length = array.length;
        if (length == 0) {
            return array;
        }


        return array;
    }
}
