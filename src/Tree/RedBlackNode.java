package src.Tree;

public class RedBlackNode <T extends Comparable<T>> extends Node<T, RedBlackNode<T>>{
    T data;
    RedBlackNode parent;
    RedBlackNode left;
    RedBlackNode right;
    int color;
}
