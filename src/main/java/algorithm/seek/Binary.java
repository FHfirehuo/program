package algorithm.seek;

/**
 * 二分法查找: 适用于数据量较大时，但是数据需要先排好顺序
 * 
 * @author liuyi27
 *         <p>
 *         时间复杂度:
 *         </p>
 *         <p>
 *         1.最坏情况查找最后一个元素（或者第一个元素）Master定理T(n)=T(n/2)+O(1)所以T(n)=O(log2n)
 *         </p>
 *         <p>
 *         2.最好情况查找中间元素O(1)查找的元素即为中间元素（奇数长度数列的正中间，偶数长度数列的中间靠左的元素）
 *         </p>
 *         <p>
 *         空间复杂度
 *         </p>
 *         <p>
 *         S(n)=logn
 *         </p>
 *
 */
public class Binary {

	/**
	 * 二分法查找
	 * 
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
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int value = binary(a, 9);
		System.out.println(value);
	}
}
