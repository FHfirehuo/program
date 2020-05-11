package algorithm.sort;

import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(Insertion.insertion(array)));
        System.out.println("排序后数组：" + Arrays.toString(Insertion.insertion2(array)));
    }

    private static int[] insertion2(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int arrayLength = array.length;

        int item;

        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j] ; j--) {
                item = array[j];
                array[j] = array[j-1];
                array[j-1] = item;
            }
        }

        return array;
    }

    private static int[] insertion(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int arrayLength = array.length;

        int current;
        int preIndex;

        for (int i = 1; i < arrayLength; i++) {
            current = array[i];
            preIndex = i -1;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            if (preIndex != i -1) {
                array[preIndex + 1] = current;
            }

        }

        return array;
    }
}
