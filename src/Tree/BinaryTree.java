package src.Tree;

public class BinaryTree<T extends Comparable<T>> extends AbstractTree<T, BinaryNode<T>> {
    public BinaryTree(){
        super.root = null;
    }
    @Override
    public void insert(T data) {
        BinaryNode<T> tempNodeTree = new BinaryNode<>(data);
        if (root == null) {
            root = tempNodeTree;
        }
        super.insertRecursive(root, tempNodeTree);
    }


    @Override
    public void deleteElement(T data) {
       root = super.deleteNode(root,data);

    }
    public void deleteAllElements(){
        root.rightChild = null;
        root.leftChild = null;
        root = null;
    }
}
