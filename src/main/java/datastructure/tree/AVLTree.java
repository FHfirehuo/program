package datastructure.tree;

/**
 * 平衡二叉树
 */
public class AVLTree<E extends Comparable> {

    private Node<E> root;

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
        this.insert(root, newNode);
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




        return origin;
    }


    private class Node<E extends Comparable> {
        E data;
        Node<E> lchild;
        Node<E> rchild;


        Node(E element) {
            this.data = (E) element;
        }

    }

}
