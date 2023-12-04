package src.Tree;

public class TreeTest4 {
    public static void main(String[] args) {
        AVLTree<Integer> avlTest = new AVLTree<>();
        avlTest.insert(19);
        avlTest.insert(20);
        avlTest.insert(654);
        avlTest.insert(349857);

        System.out.println("Before delete:");
        avlTest.inLevel();

        avlTest.deleteElement(654);
        avlTest.deleteElement(20);
        System.out.println("\nAfter delet:");
        avlTest.inLevel();



    }
}
