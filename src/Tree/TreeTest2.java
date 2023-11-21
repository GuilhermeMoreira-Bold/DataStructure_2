package src.Tree;

public class TreeTest2 {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(0);
        binarySearchTree.insert(60);
        binarySearchTree.insert(-10);
        binarySearchTree.insert(50);


        System.out.println("Original tree:");
        binarySearchTree.inLevel();

        DSW dsw = new DSW(binarySearchTree);
        binarySearchTree = dsw.getBalancedTree();

        System.out.println("\nBalenced tree:");
        binarySearchTree.inLevel();
    }
}
