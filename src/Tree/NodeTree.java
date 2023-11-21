package src.Tree;



public class NodeTree {
     int data;
     NodeTree leftChild;
     NodeTree rightChild;

    NodeTree(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return "NodeTree{" +
                "data=" + data +
                '}';
    }
}
