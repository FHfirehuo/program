package algorithm.seek;

/**
 * 二分法查找: 适用于数据量较大时，但是数据需要先排好顺序
 */
public class BinarySearch {

    /**
     * @param array  数集合
     * @param target 目标数
     */
    private static int binary(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;

            if (target == array[middle]) {
                return middle;
            }

            if (target > array[middle]) {
                low = middle + 1;
            }

            if (target < array[middle]) {
                high = middle - 1;
            }
        }

        // 没找到返回 -1
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int value = binary(a, 9);
        System.out.println(value);
    }
}
