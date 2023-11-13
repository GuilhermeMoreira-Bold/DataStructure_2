package src.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class TreeTest {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for(int i = 0; i < 20; i++){
            int newInt = random.nextInt(0,100);
            binarySearchTree.insert(newInt);
            numbers.add(newInt);
        }
        System.out.println("Numbers order: "+ numbers.toString());

        System.out.println("\nTree in order: ");
        binarySearchTree.inOrderTraversal();

        System.out.println("\nTree result preOrder: ");
        binarySearchTree.preOrderTraversal();

        System.out.println("\nTree in postOrder:");
        binarySearchTree.postOrderTraversal();

        System.out.println("\nTree in level:");
        binarySearchTree.inLevel();
        for (int i = 0; i < 5; i++) {
            binarySearchTree.deleteNode(numbers.get(i));
            numbers.remove(i);
        }

        System.out.println("\nNumbers order: "+ numbers.toString());

        System.out.println("\nTree in order: ");
        binarySearchTree.inOrderTraversal();

        System.out.println("\nTree result preOrder: ");
        binarySearchTree.preOrderTraversal();

        System.out.println("\nTree in postOrder:");
        binarySearchTree.postOrderTraversal();

        System.out.println("\nTree in level:");
        binarySearchTree.inLevel();



    }
}
