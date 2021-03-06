package datastructure.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 平衡二叉树
 */
public class AVLTree<E extends Comparable> {

    private Node<E> root;


    /**
     * 层序遍历
     * <p>
     * 层次遍历就是按照树的层次自上而下的遍历二叉树
     * </p>
     */
    public void LayerOrder() {

        Queue<Node> queue = new LinkedBlockingDeque<>();
        queue.add(root);
        LayerOrder(queue);



    }

    private void LayerOrder(Queue<Node> queue) {

        Node nextNode = queue.poll();
        if (nextNode == null){
            return;
        }

        System.out.println(nextNode.data);


        if (nextNode.lchild != null) {
            queue.add(nextNode.lchild);
        }

        if (nextNode.rchild != null) {
            queue.add(nextNode.rchild);
        }

        LayerOrder(queue);
    }

    /**
     * 左旋
     *
     * @param element
     * @return 返回的是左旋后的根节点，左旋后的根节点是原来根节点的右孩子，左旋后的根节点的左孩子需要嫁接到原来根节点的右孩子上，原来的根节点嫁接到左旋后根节点的左孩子上。temp对应上图中值为8的节点，root对应上图中值为4的节点。
     */
    private Node<E> leftRotate(Node<E> element) {
        Node<E> temp = element.rchild;
        element.rchild = temp.lchild;
        temp.lchild = element;
        return temp;
    }


    /**
     * 右旋 返回的是右旋后的根节点，右旋后的根节点是原来根节点的左孩子，右旋后的根节点的右孩子需要嫁接到原来根节点的左孩子上，原来的根节点嫁接到右旋后根节点的右孩子上。temp对应上图中值为5的节点，root对应上图中值为9的节点。
     *
     * @param element
     * @return
     */
    private Node<E> rightRotate(Node<E> element) {
        Node<E> temp = element.lchild;
        element.lchild = temp.rchild;
        temp.rchild = element;
        return temp;
    }


    /**
     * 先左旋再右旋
     *
     * @param element
     * @return 返回的是LR旋转后的根节点，先对根节点的左子树左旋，再整体右旋。root对应上图中值为9的节点。
     */
    private Node<E> leftRightRotate(Node<E> element) {

        //先对element的左子树左旋
        element.lchild = this.leftRotate(element.lchild);
        //再对element右旋
        return rightRotate(element);
    }

    /**
     * @param element
     * @return 返回的是RL旋转后的根节点，先对根节点的右子树右旋，再整体左旋。root对应上图中值为4的节点。
     */
    private Node<E> rightLeftRotate(Node<E> element) {

        //先对element的左子树左旋
        element.rchild = this.rightRotate(element.rchild);
        //再对element右旋
        return leftRotate(element);
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        root = this.insert(root, newNode);
    }

    private Node<E> insert(Node<E> origin, Node<E> newNode) {
        if (origin == null) {

            origin = newNode;

        } else if (origin.data.compareTo(newNode.data) < 0) {
            //小
            origin.rchild = insert(origin.rchild, newNode);

        } else {
            //大等于
            origin.lchild = insert(origin.lchild, newNode);
        }

        boolean balance = isBalance(origin);
        if (!balance){
            origin = adjustment(origin, newNode);
        }

        return origin;
    }

    private Node<E> adjustment(Node<E> origin, Node<E> newNode) {

        if (origin.lchild != null && origin.lchild.data.compareTo(newNode.data) > 0 ){
            //新节点小于不平衡节点的左节点则是插入了左子树的左子树
            //RR型
            return rightRotate(origin);
        }

        if (origin.rchild.data.compareTo(newNode.data) < 0){
           //新节点大于不平衡节点的右节点则是插入了右子树的右子树
            //LL型
            return leftRotate(origin);
        }

        if (origin.lchild.data.compareTo(newNode.data) < 0 ){
            //新节点大于不平衡节点的左节点则是插入了左子树的右子树
            //LR型
            return leftRightRotate(origin);
        }

        if (origin.rchild.data.compareTo(newNode.data) > 0){
            //新节点小于不平衡节点的右节点则是插入了右子树的左子树
            //RL型
            return rightRotate(origin);
        }

        return origin;
    }

    private boolean isBalance(Node<E> origin) {
        return isBalancedTreeHelper(origin).balanced;
    }

    private TreeInfo isBalancedTreeHelper(Node<E> origin) {

        if (origin == null){
            return  new TreeInfo(-1, true);
        }

        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(origin.lchild);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(origin.rchild);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }
        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }


    private final class TreeInfo{
        int height;
        boolean balanced;

        TreeInfo(int height, boolean balanced){
            this.height = height;
            this.balanced =balanced;
        }
    }



    private class Node<E extends Comparable> {
        E data;
        Node<E> lchild;
        Node<E> rchild;


        Node(E element) {
            this.data = (E) element;
        }

    }


    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.LayerOrder();
    }

}
