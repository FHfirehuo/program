package algorithm.sort;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(Selection.selection(array)));
    }

    private static int[] selection(int[] array) {
        if(array.length < 2){
            return array;
        }

        int arrayLength = array.length;
        int item = 0;
        int minIndex = 0;
        for (int i = 0; i < arrayLength; i++) {
            minIndex = i;
            for (int j = i; j < arrayLength; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                item = array[i];
                array[i] = array[minIndex];
                array[minIndex] = item;
            }

        }

        return array;
    }
}
