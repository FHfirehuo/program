package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BucketSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5, 7, 6};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(BucketSort.bucketSort(array, 3)));
    }

    private static int[] bucketSort(int[] array, int buketSize) {
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

        //求出桶的数量
        int bucketCount = (max - min) / buketSize + 1;
        List<Integer> originList = Arrays.stream(array).boxed().collect(Collectors.toList());

        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < array.length; i++) {
            bucketArr.get((originList.get(i) - min) / buketSize)
                    .add(originList.get(i));
        }

        int index = 0;
        for (ArrayList<Integer> bucket : bucketArr) {
            //这里应该桶内排序
            for (int b : bucket) {
                array[index++] = b;
            }
        }

        return array;
    }
}
