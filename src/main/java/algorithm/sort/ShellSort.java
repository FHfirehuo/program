package algorithm.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(ShellSort.shell(array)));
    }


    private static int[] shell(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        int tmp, preIndex, gap = length / 2;
        while (gap > 0) {

            for (int i = gap; i < length; i++) {
                tmp = array[i];
                preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > array[preIndex + gap]) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = tmp;
            }

            gap = gap / 2;
        }
        return array;
    }
}
