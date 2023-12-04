package src.Tree;

public abstract class  Node <T extends Comparable<T>, N extends Node<T, N>> implements Comparable<N>{
    float x,y;
    T data;
    N leftChild;
    N  rightChild;
    @Override
    public int compareTo(N otherNode){
        return this.data.compareTo(otherNode.data);
    }

    public N getLeftChild(){
        return this.leftChild;
    }
}
