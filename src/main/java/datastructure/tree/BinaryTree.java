package datastructure.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 二叉树
 * 
 * <p>
 * 定义:二叉树是n(n>=0)个结点的有限集合，该集合或者为空集（称为空二叉树），或者由一个根结点和两棵互不相交的、分别称为根结点的左子树和右子树组成
 * </p>
 * <p>
 * 二叉树特点: 由二叉树定义以及图示分析得出二叉树有以下特点： 1）每个结点最多有两颗子树，所以二叉树中不存在度大于2的结点。
 * 2）左子树和右子树是有顺序的，次序不能任意颠倒。 3）即使树中某结点只有一棵子树，也要区分它是左子树还是右子树。
 * </p>
 * <p>
 * 二叉树性质: 1）在二叉树的第i层上最多有2i-1 个节点 。（i>=1） 2）二叉树中如果深度为k,那么最多有2k-1个节点。(k>=1）
 * 3）n0=n2+1 n0表示度数为0的节点数，n2表示度数为2的节点数。
 * 4）在完全二叉树中，具有n个节点的完全二叉树的深度为[log2n]+1，其中[log2n]是向下取整。 5）若对含 n
 * 个结点的完全二叉树从上到下且从左至右进行 1 至 n 的编号，则对完全二叉树中任意一个编号为 i 的结点有如下特性：
 * </p>
 * <p>
 * (1) 若 i=1，则该结点是二叉树的根，无双亲, 否则，编号为 [i/2] 的结点为其双亲结点; (2) 若 2i>n，则该结点无左孩子， 否则，编号为
 * 2i 的结点为其左孩子结点； (3) 若 2i+1>n，则该结点无右孩子结点， 否则，编号为2i+1 的结点为其右孩子结点。 。
 * </p>
 * 
 * @author liuyi27
 *
 */
@Setter
@Getter
public class BinaryTree {

	private Object data;
	private BinaryTree lchild, rchild;

	/**
	 * 前序遍历递归算法
	 * <p>
	 * 前序遍历通俗的说就是从二叉树的根结点出发，当第一次到达结点时就输出结点数据，按照先向左再向右的方向访问。
	 * </p>
	 */
	public void preOrderTraverse(BinaryTree tree) {
		if (tree == null) {
			return;
		}

		System.out.print(tree.getData());
		preOrderTraverse(tree.getLchild());
		preOrderTraverse(tree.getRchild());
	}

	/**
	 * 中序遍历递归算法
	 * <p>
	 * 中序遍历就是从二叉树的根结点出发，当第二次到达结点时就输出结点数据，按照先向左再向右的方向访问
	 * </p>
	 */
	public void inOrderTraverse(BinaryTree tree) {
		if (tree == null) {
			return;
		}

		inOrderTraverse(tree.getLchild());
		System.out.print(tree.getData());
		inOrderTraverse(tree.getRchild());
	}

	/**
	 * 后序遍历递归算法
	 * <p>
	 * 后序遍历就是从二叉树的根结点出发，当第三次到达结点时就输出结点数据，按照先向左再向右的方向访问
	 * </p>
	 */
	public void postOrderTraverse(BinaryTree tree) {
		if (tree == null) {
			return;
		}

		postOrderTraverse(tree.getLchild());
		postOrderTraverse(tree.getRchild());
		System.out.print(tree.getData());
	}

	/**
	 * 前序建立二叉树
	 */
	public static void preCreate() {

	}

	/**
	 * 层序遍历
	 * <p>
	 * 层次遍历就是按照树的层次自上而下的遍历二叉树
	 * </p>
	 * 
	 * @param node
	 * @param queue
	 */
	public void LayerOrder(BinaryTree node, Queue<BinaryTree> queue) {

		if (node != null && queue.isEmpty()) {
			// 将当前节点放入队列首指针所指位置
			queue.add(node);
			System.out.print(queue.poll().getData());
		} else {
			System.out.print(node.getData());
		}

		if (node.lchild != null) {
			queue.add(node.lchild);
		}

		if (node.rchild != null) {
			queue.add(node.rchild);
		}

		BinaryTree nextNode = queue.poll();
		if (nextNode != null) {
			this.LayerOrder(nextNode, queue);
		}

	}

	public static void main(String[] args) {

		BinaryTree biTree2L3L = new BinaryTree();
		biTree2L3L.setData("D");

		BinaryTree biTree2L = new BinaryTree();
		biTree2L.setData("B");
		biTree2L.setLchild(biTree2L3L);

		BinaryTree biTree2R = new BinaryTree();
		biTree2R.setData("C");

		BinaryTree biTree = new BinaryTree();
		biTree.setData("A");
		biTree.setLchild(biTree2L);
		biTree.setRchild(biTree2R);

		Queue<BinaryTree> queue = new LinkedBlockingDeque<BinaryTree>();
		biTree.LayerOrder(biTree, queue);
		System.out.println("");
		biTree.preOrderTraverse(biTree);
		System.out.println("");
		biTree.inOrderTraverse(biTree);
		System.out.println("");
		biTree.postOrderTraverse(biTree);


	}
}
