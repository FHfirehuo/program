package datastructure.tree;

/**
 * 树结构
 */
public interface FireTree<T> {


    /**
     * 前序遍历递归算法
     * <p>
     * 前序遍历通俗的说就是从树的根结点出发，当第一次到达结点时就输出结点数据，按照先向左再向右的方向访问。
     * </p>
     */
    T[] preOrderTraverse();

    /**
     * 中序遍历递归算法
     * <p>
     * 中序遍历就是从树的根结点出发，当第二次到达结点时就输出结点数据，按照先向左再向右的方向访问
     * </p>
     */
    T[] inOrderTraverse();

    /**
     * 后序遍历递归算法
     * <p>
     * 后序遍历就是从树的根结点出发，当第三次到达结点时就输出结点数据，按照先向左再向右的方向访问
     * </p>
     */
    T[] postOrderTraverse();



    /**
     * 层序遍历
     * <p>
     * 层次遍历就是按照树的层次自上而下的遍历树
     * </p>
     */
    T[] LayerOrder();


    boolean add(T element);

    int size();

}
