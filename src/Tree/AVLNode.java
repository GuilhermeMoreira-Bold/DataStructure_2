package src.Tree;

public class AVLNode <T extends Comparable<T>> extends Node<T, AVLNode<T>>{
     int height;
    public AVLNode(T data){
        super.data = data;
        super.leftChild = null;
        super.rightChild = null;
        height = 1;
    }
}