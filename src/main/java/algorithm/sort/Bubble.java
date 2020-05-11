package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {

    public static void main(String[] args) {

        //int[] array = {1, 2, 9, 4, 6, 7, 8, 3, 0, 5};
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("原始数组：" + Arrays.toString(array));
//        System.out.println("排序后数组：" + Arrays.toString(Bubble.bubble(array)));

        System.out.println("排序后数组：" + Arrays.toString(Bubble.bubble2(array)));
    }

    //这种是大家常写的最优也是n^2达不到n的
    public static int[] bubble(int[] origin) {
        if (origin.length < 2) {
            return origin;
        }

        int arrayLength = origin.length;
        int item = 0;
        int quence = 0;

        for (int i = 0; i < arrayLength; i++) { //外循环为排序趟数，arrayLength 个数进行 arrayLength-1 趟
            int endLength = arrayLength - 1 - i;
            for (int j = 0; j < endLength; j++) { //内循环为每趟比较的次数，第i趟比较arrayLength-i次
                quence ++;
                if (origin[j] > origin[j + 1]) {
                    quence ++;
                    item = origin[j + 1];
                    quence ++;
                    origin[j + 1] = origin[j];
                    quence ++;
                    origin[j] = item;
                }
            }
        }
        System.out.println(quence);
        return origin;
    }

    //这种是优化过的最优是n
    public static int[] bubble2(int[] origin) {
        if (origin.length < 2) {
            return origin;
        }
        int quence = 0;
        int item;
        boolean next;
        int time = 0;
        do {
            next = false;
            int endLength = origin.length - 1 - time;
            for (int j = 0; j < endLength; j++) {
                //内循环为每趟比较的次数，第i趟比较arrayLength-i次
                quence ++;
                if (origin[j] > origin[j + 1]) {
                    quence ++;
                    item = origin[j + 1];
                    quence ++;
                    origin[j + 1] = origin[j];
                    quence ++;
                    origin[j] = item;
                    next = !next || next;
                }
            }
            time ++;
        } while (next); //外循环为排序趟数，如果有交换就进行下一趟

        System.out.println(quence);
        return origin;
    }
}
