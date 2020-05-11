package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(QuickSort.quickSort1(array)));

    }

    //填坑法
    private static int[] quickSort1(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        sort1(array, 0, length -1);

        return array;
    }

    private static void sort1(int[] array, int left, int right) {
        //pivot pivət 枢纽
        int pivot = array[0];
        while (left != right){

        }
    }

    //指针发
    private static int[] quickSort2(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        return array;
    }

    //指针发 + 随机pivot
    private static int[] quickSort3(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        return array;
    }

    //队列法
    private static int[] quickSort4(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

        return array;
    }
}
