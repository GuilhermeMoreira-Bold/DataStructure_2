package src.Tree;

public class RedBlackNode <T extends Comparable<T>> extends Node<T, RedBlackNode<T>>{
    RedBlackNode<T> parent;
    int color;
    public boolean isLeft;
    public RedBlackNode(T data){
        super.data = data;
        super.leftChild = null;
        super.rightChild = null;
        this.isLeft = false;
    }
}
