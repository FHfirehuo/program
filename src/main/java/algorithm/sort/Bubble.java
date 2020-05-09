package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {

    public static void main(String[] args) {

        int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        System.out.println("原始数组：" + Arrays.toString(array));
        System.out.println("排序后数组：" + Arrays.toString(Bubble.bubble(array)));
    }

    public static int[] bubble(int[] origin) {
        if (origin.length < 1) {
            return origin;
        }

        int arrayLength = origin.length;
        int item = 0;

        for (int i = 0; i < arrayLength; i++) { //外循环为排序趟数，arrayLength 个数进行 arrayLength-1 趟
            int endLength = arrayLength - 1 - i;
            for (int j = 0; j < endLength; j++) { //内循环为每趟比较的次数，第i趟比较arrayLength-i次
                if (origin[j] > origin[j + 1]) {
                    item = origin[j + 1];
                    origin[j + 1] = origin[j];
                    origin[j] = item;
                }
            }
        }
        return origin;
    }
}
