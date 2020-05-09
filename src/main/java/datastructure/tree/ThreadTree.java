package datastructure.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 线索二叉树
 * <p>
 * 产生背景:现有一棵结点数目为n的二叉树，采用二叉链表的形式存储。对于每个结点均有指向左右孩子的两个指针域，而结点为n的二叉树一共有n-1条有效分支路径。那么，则二叉链表中存在2n-(n-1)=n+1个空指针域。那么，这些空指针造成了空间浪费。
 * </p>
 * <p>
 * 线索化:若结点的左子树为空，则该结点的左孩子指针指向其前驱结点。 若结点的右子树为空，则该结点的右孩子指针指向其后继结点。
 * </p>
 * <p>
 * 线索化带来新问题:可以将一棵二叉树线索化为一棵线索二叉树，那么新的问题产生了。我们如何区分一个结点的lchild指针是指向左孩子还是前驱结点呢？例如：对于图2.2所示的结点E，如何区分其lchild的指向的结点J是其左孩子还是前驱结点呢？
 * 为了解决这一问题，现需要添加标志位ltag，rtag。并定义规则如下：
 * 
 * ltag为0时，指向左孩子，为1时指向前驱 rtag为0时，指向右孩子，为1时指向后继
 * </p>
 * 
 * @author liuyi27
 * 
 *         结语 线索二叉树充分利用了指针空间，同时又便于寻找结点的前驱结点和后继结点。线索二叉树适用于经常需要遍历寻找结点前驱或者后继结点的二叉树
 *
 */
@Getter
@Setter
public class ThreadTree {

	private Object data;
	private ThreadTree lchild, rchild;
	// ltag为0(LINK)时，指向左孩子，为1(THREAD)时指向前驱
	// rtag为0(LINK)时，指向右孩子，为1(THREAD)时指向后继
	private PointerTag ltag, rtag;

	/**
	 * 中序遍历进行中序线索化
	 */
	public ThreadTree inThreading(ThreadTree tree, ThreadTree p) {
		if (tree == null) {
			return p;
		}

		// 左子树线索化
		p = inThreading(tree.getLchild(), p);

		// 中序排序打印值
		System.out.print(tree.getData());

		if (tree.getLchild() == null) {
			// 当前结点的左孩子为空则指向前驱,但首位前驱为null
			tree.setLtag(PointerTag.THREAD);
			tree.setLchild(p);
		} else {
			tree.setLtag(PointerTag.LINK);
		}

		if (p != null && p.getRchild() == null) {
			// 前驱结点的右孩子为空
			p.setRtag(PointerTag.THREAD);
			p.setRchild(tree);
		} else if (p != null) {
			p.setRtag(PointerTag.LINK);
		}

		p = tree;
		// 右子树线索化
		p = inThreading(tree.getRchild(), p);

		return p;

	}

	/**
	 * 中序遍历打印二叉线索树T（非递归算法）
	 * 
	 * @param tree 指向头结点，头结点的lchild链域指针指向二叉树的根结点
	 */
	public void inOrderTraversePrint(ThreadTree tree) {
		if (tree == null) {
			return;
		}
		// p指向根结点
		ThreadTree p = tree.getLchild();

		// 空树遍历结束，p == T
		while (p != null) {

			while (p.ltag == PointerTag.LINK) {
				p = p.getLchild();
			}
			// 此时p指向中序遍历序列的第一个结点（最左下的结点）

			// 打印（访问）其左子树为空的结点
			System.out.print(p.getData());

			while (p.rtag == PointerTag.THREAD && p != null) {
				p = p.getRchild();
				// 访问后继结点
				System.out.print(p.getData());
			}

			// 当p所指结点的rchild指向的是孩子结点而不是线索时，
			// p的后继应该是其右子树的最左下的结点，即遍历其右子树时访问的第一个节点
			p = p.rchild;

		}
	}

	@Getter
	@AllArgsConstructor
	enum PointerTag {
		// 结点的child域类型，link表示是指针，指向孩子结点，thread表示是线索，指示前驱或后继结点
		// ltag为0时，指向左孩子，为1时指向前驱;rtag为0时，指向右孩子，为1时指向后继
		LINK(0), THREAD(1),;
		private int value;

	}

	public static void main(String[] args) {

		ThreadTree treTree2L3L = new ThreadTree();
		treTree2L3L.setData("D");
		ThreadTree treTree2L3R = new ThreadTree();
		treTree2L3R.setData("E");

		ThreadTree treTree2L = new ThreadTree();
		treTree2L.setData("B");
		treTree2L.setLchild(treTree2L3L);
		treTree2L.setRchild(treTree2L3R);

		ThreadTree treTree2R = new ThreadTree();
		treTree2R.setData("C");

		ThreadTree treTree = new ThreadTree();
		treTree.setData("A");
		treTree.setLchild(treTree2L);
		treTree.setRchild(treTree2R);

		treTree.inThreading(treTree, null);
		System.out.println("");
		treTree.inOrderTraversePrint(treTree);

	}
}
