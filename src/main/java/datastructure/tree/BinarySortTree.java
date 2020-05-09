package datastructure.tree;


import lombok.Setter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 二叉排序树：二叉排序树（Binary Sort Tree），又称二叉查找树（Binary Search Tree），也称二叉搜索树。
 * 
 * @author liuyi27
 * 
 *         <p>
 *         二叉排序树或者是一棵空树，或者是具有下列性质的二叉树:
 *         </p>
 *         <p>
 *         （1）若左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
 *         </p>
 *         <p>
 *         （2）若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值；
 *         </p>
 *         <p>
 *         （3）左、右子树也分别为二叉排序树；
 *         </p>
 *
 */
@Setter
public class BinarySortTree {

	private int data;
	private BinarySortTree lchild, rchild;

	/**
	 * 递归查找二叉排序树T中是否存在key 指针f指向T的双亲，其初始调用值为NULL 若查找成功，* 则指针p指向该数据元素结点，并返回TRUE
	 * 否则指针p指向查找路径上访问的最后一个结点并返回FALSE
	 */
	// 如果树是空的，则查找结束，无匹配。
	// 如果被查找的值和根结点的值相等，查找成功。否则就在子树中继续查找。如果被查找的值小于根结点的值就选择左子树，大于根结点的值就选择右子树。
	public static boolean search(BinarySortTree tree, int key) {

		if (tree == null) {
			return false;
		}

		if (tree.data == key) {

			return true;
		}
		System.out.println(tree.data);
		if (key < tree.data) {
			System.out.println("<");
			/* 在左子树中继续查找 */
			return search(tree.lchild, key);
		} else {
			System.out.println(">");
			/* 在右子树中继续查找 */
			return search(tree.rchild, key);
		}
	}

	/**
	 * 若查找的key已经有在树中，则p指向该数据结点。 若查找的key没有在树中，则p指向查找路径上最后一个结点。
	 * 
	 * @param tree
	 * @param key
	 * @return
	 */
	public static BinarySortTree add(BinarySortTree tree, int key) {
		if (tree == null) {
			tree = new BinarySortTree();
			tree.data = key;
			return tree;
		}

		if (key < tree.data) {
			tree.lchild = add(tree.lchild, key);
		} else {
			tree.rchild = add(tree.rchild, key);
		}
		return tree;
	}

	public static BinarySortTree create(BinarySortTree tree, int[] array) {

		for (int i = 0; i < array.length; i++) {
			tree = add(tree, array[i]);
		}

		return tree;
	}

	public static boolean remove(BinarySortTree tree, int key) {
		if (tree == null) {

			return false;
		}

		if (tree.data == key) {
			return delete(tree);
		} else if (tree.data > key) {
			return remove(tree.lchild, key);
		} else {
			return remove(tree.rchild, key);
		}

	}

	/**
	 * 1）删除结点为叶子结点； 2）删除的结点只有左子树； 3）删除的结点只有右子树 4）删除的结点既有左子树又有右子树。
	 * 
	 * @param tree
	 * @return
	 */
	private static boolean delete(BinarySortTree tree) {

		if (tree.rchild == null) {
			// 右子树空则只需重接它的左子树（待删结点是叶子也走此分支)
			tree = tree.lchild;
		} else if (tree.lchild == null) {
			// 只需重接它的右子树
			tree = tree.rchild;
		} else {
			// 左右子树均不空
			// 转左
			BinarySortTree tempP = null;
			BinarySortTree temp = tree.lchild;
			// 然后向右到尽头（找待删结点的前驱）
			while (temp.rchild != null) {
				tempP = temp;
				temp = temp.rchild;
			}
			
			// TODO 感觉非常有问题
			if (tempP != null) {
				tempP.rchild = null;
			}else {
				temp.lchild = null;
			}
			
			// 将被删结点前驱的值取代被删结点的值(指向被删结点的直接前驱)
			tree.data = temp.data;

		}

		return true;
	}

	public static void layerOrder(BinarySortTree node, Queue<BinarySortTree> queue) {

		if (node != null && queue.isEmpty()) {
			// 将当前节点放入队列首指针所指位置
			queue.add(node);
			System.out.print(queue.poll().data + " ");
		} else {
			System.out.print(node.data + " ");
		}

		if (node.lchild != null) {
			queue.add(node.lchild);
		}

		if (node.rchild != null) {
			queue.add(node.rchild);
		}

		BinarySortTree nextNode = queue.poll();
		if (nextNode != null) {
			layerOrder(nextNode, queue);
		}

	}

	public static void main(String[] args) {

		int[] array = { 10, 4, 6, 34, 32, 5, 2, 1, 11, 23 };
		BinarySortTree tree = null;
		tree = create(tree, array);
		Queue<BinarySortTree> queue = new LinkedBlockingDeque<BinarySortTree>();
		layerOrder(tree, queue);

		System.out.println("查找1");
//		System.out.println(search(tree, 10));
//		System.out.println(search(tree, 4));
//		System.out.println(search(tree, 6));
//		System.out.println(search(tree, 34));
//		System.out.println(search(tree, 32));
//		System.out.println(search(tree, 5));
//		System.out.println(search(tree, 2));
//		System.out.println(search(tree, 11));
//		System.out.println(search(tree, 23));
		System.out.println("查找1");
		boolean result = remove(tree, 4);
		System.out.println("");
		System.out.println(result);
		layerOrder(tree, queue);
		System.out.println("");
		System.out.println("查找2");
//		System.out.println(search(tree, 10));
//		System.out.println(search(tree, 4));
//		System.out.println(search(tree, 34));
//		System.out.println(search(tree, 32));
//		System.out.println(search(tree, 2));
//		System.out.println(search(tree, 11));
//		System.out.println(search(tree, 23));
		System.out.println(search(tree, 5));
		System.out.println(search(tree, 6));
	}
}
