package src.Tree;


import java.util.Random;

public class TreeTest3 {

    public static void main(String[] args) {
//        WindowManager manage = new WindowManager();
//        manage.init();
//        AVLNode<Integer> node = new AVLNode<>(12);
//        manage.render(node);
//
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        Random rand = new Random();
        System.out.print("Numbers:");
//        for(int i = 0; i < 10;i ++){
//            int newInt = rand.nextInt(0, 100);
//            binaryTree.insertElement(newInt);
//            System.out.print(" " + newInt);
//        }
        binaryTree.insert(1731820);
        binaryTree.insert(9584);
        binaryTree.insert(41238);
        binaryTree.insert(6457);
        binaryTree.insert(3246);
        binaryTree.insert(6346675);
        binaryTree.insert(14);
        binaryTree.insert(33);
        binaryTree.insert(42);
        binaryTree.insert(100);



        binaryTree.deleteElement(100);

        System.out.println("Numbers in the tree");
        binaryTree.inOrder();
        System.out.println("\nNumbers in the tree in post order");
        binaryTree.postOrder();
        System.out.println("\nNumbers in the tree in level");
        binaryTree.inLevel();
        System.out.println("\nNumbers in the tree pre order");
        binaryTree.preOrder();
    }
}
