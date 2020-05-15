package algorithm.sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5, 7, 6};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(CountingSort.countingSort(array)));
    }

    private static int[] countingSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int min = array[0], max = array[0];
        for (int a : array) {
            if (a < min) {
                min = a;
            }
            if (a > max) {
                max = a;
            }
        }

        //根据数列最大值和最小值的差值确定统计数组的长度
        int[] buket = new int[max - min + 1];

        //偏移量
        int bias = 0 - min;

        for (int i = 0; i < array.length; i++) {
            //buket[array[i] + bias] = ++buket[array[i] + bias];
            buket[array[i] + bias] ++;
        }

        int index = 0;
        for (int i = 0; i < buket.length; i++) {
            for (int j = 0; j < buket[i]; j++) {
                array[index++] = i + bias;
            }
        }


        return array;
    }

}
