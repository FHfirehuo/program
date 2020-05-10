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
        if (length == 0) {
            return array;
        }

        int tmp, gap = length / 2;

        while (gap > 0) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < length; i++) {
                tmp = array[i];
                int preIndex = i - gap;
                while (preIndex > 0 && array[preIndex] > tmp) {
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
