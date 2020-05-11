package algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        //System.out.println("排序后数组：" + Arrays.toString(MergeSort.mergeSort(array)));
        System.out.println("排序后数组：" + Arrays.toString(MergeSort.mergeSort2(array)));
    }


    private static int[] mergeSort2(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }

//        int left

        return array;
    }



    private static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }


        int mid = length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, length);

        return merge(mergeSort(left), mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {
        int itemLength = left.length + right.length;
        int item[] = new int[itemLength];
        //l 为left的指针
        //r 为right的指针
        for (int index = 0, l = 0, r = 0; index < itemLength; index++) {
            if (l >= left.length) {
                //左数组已经遍历完
                item[index] = right[r++];
            } else if (r >= right.length) {
                //右侧数组已经遍历完
                item[index] = left[l++];
            } else if (left[l] > right[r]) {
                //这样是为了保证稳定性
                item[index] = right[r++];
            } else {
                item[index] = left[l++];
            }
        }

        return item;
    }

}
