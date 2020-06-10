package datastructure.tree;

import java.util.Objects;

public class FireBinaryTree<E> extends AbstractFireTree<E> {

    private Node<E> root;
    private int size;

    @Override
    public boolean add(E element) {

        if (element == null){
            return false;
        }

        return addNode(root, element) == null;
    }

    @Override
    public int size() {
        return size;
    }

    private E addNode(Node<E> node, E element) {
        E old = node.data;

        if (old == null){
            node.data = element;
            size ++;
        }else if (Objects.equals(node.data, element)){
            //如果有相同值则添加失败
            return old;
        }else if(node.lChild == null){
            old = addNode(node.lChild, element);
        }else {
            old = addNode(node.rChild, element);
        }

        return old;
    }


    private class Node<E> {
        E data;
        Node<E> lChild, rChild;

        Node(E element) {
            this.data = element;
        }
    }
}
