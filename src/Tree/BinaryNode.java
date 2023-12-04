package src.Tree;

public class BinaryNode<T extends  Comparable<T>> extends Node<T, BinaryNode<T>>{
    BinaryNode(T data){
        super.data = data;
        super.leftChild = null;
        super.rightChild = null;
    }
}
