package algorithm.seek;

import java.util.Arrays;

/**
 * 斐波那契查找算法（黄金分割查找算法）:斐波那契查找就是在二分查找的基础上根据斐波那契数列进行分割的
 * 
 * @author liuyi27 斐波那契查找的时间复杂度还是O(log 2 n )
 *         <p>
 *         与折半查找相比，斐波那契查找的优点是它只涉及加法和减法运算，而不用除法，而除法比加减法要占用更多的时间，因此，斐波那契查找的运行时间理论上比折半查找小，但是还是得视具体情况而定。
 *         </p>
 */
public class FibonacciSearch {

	// 斐波那契数组的长度
	public final static int MAX_SIZE = 20;

	/**
	 * [0, 1，1，2，3，5，8，13，21，34, ...]
	 * 
	 * @return 斐波那契数列
	 */
	public static  int[] fibonacci() {
		int[] f = new int[MAX_SIZE];
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i < MAX_SIZE; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static  int fibonacciSearch(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		int mid = 0;

		// 获取斐波那契数列
		int[] f = fibonacci();

		// 斐波那契分割数值下标
		int k = 0;

		// 获取斐波那契分割数值下标
		// 找出数组的长度在斐波数列（减1）中的位置，将决定如何拆分
		while (data.length > f[k] - 1) {
			k++;
		}

		// 创建临时数组
		// 构造一个长度为fb[k] - 1的新数列
		// 及数组的斐波那契前半部
		int[] temp = Arrays.copyOf(data, f[k]);

		// 对新构造的数组进行 元素补充
		// 比如data的长度是10 那么k=7 f[7] = 13; 则新数组 10， 11， 12 位是空的。为了避免空查找所以把data的最高位补给空位
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = data[high];
		}

		while (low <= high) {
			// 由于前面部分有f[k-1]个元素
			mid = low + f[k - 1] - 1;
			if (key < temp[mid]) {// 关键字小于切割位置元素 继续在前部分查找
				high = mid - 1;
				/*
				 * 全部元素=前部元素+后部元素 f[k]=f[k-1]+f[k-2] 因为前部有f[k-1]个元素,所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
				 * 即在f[k-1]的前部继续查找 所以k-- 即下次循环 mid=f[k-1-1]-1
				 */
				k--;
			} else if (key > temp[mid]) {// 关键字大于切个位置元素 则查找后半部分
				low = mid + 1;
				/*
				 * 全部元素=前部元素+后部元素 f[k]=f[k-1]+f[k-2] 因为后部有f[k-2]个元素,所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
				 * 即在f[k-2]的前部继续查找 所以k-=2 即下次循环 mid=f[k-1-2]-1
				 */
				k -= 2;
			} else {
				if (mid <= high) {
					return mid;
				} else {
					return high;
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9, 11, 12 };
		int i = fibonacciSearch(a, 5);
		System.out.println("5在：" + (i + 1));
		int j = fibonacciSearch(a, 12);
		System.out.println("12在：" + (j + 1));
	}

}
