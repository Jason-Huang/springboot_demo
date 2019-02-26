package cn.jason.demo.rbtree;

public class RBNode<T extends Comparable<T>> {
    /**
     * 颜色
     */
    boolean color;
    /**
     * 关键字(键值)
     */
    T key;
    /**
     * 左子节点
     */
    RBNode left;
    /**
     * 右子节点
     */
    RBNode right;
    /**
     * 父节点
     */
    RBNode parent;


    public RBNode(T key, boolean color, RBNode parent, RBNode left, RBNode right) {
        this.key = key;
        this.color = color;

        this.parent = parent;

        this.left = left;

        this.right = right;
    }


    public T getKey() {

        return key;
    }

    @Override
    public String toString() {
        return "" + key + (this.color == true ? "R" : "B");
    }

}