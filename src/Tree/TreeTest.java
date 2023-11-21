package src.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class TreeTest {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        for(int i = 0; i < 20; i++){
//            int newInt = random.nextInt(0,20);
//            binarySearchTree.insert(newInt);
//            numbers.add(newInt);
//        }
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(0);
        binarySearchTree.insert(60);
        binarySearchTree.insert(-10);
        binarySearchTree.insert(-9);
        binarySearchTree.insert(90);
        binarySearchTree.insert(70);
        binarySearchTree.insert(200);
        binarySearchTree.insert(-20);
        binarySearchTree.insert(-220);
        binarySearchTree.insert(2220);
        
        
        
        System.out.println("Numbers order: "+ numbers.toString());

        System.out.println("\nTree in order: ");
        binarySearchTree.inOrderTraversal();

        System.out.println("\nTree result preOrder: ");
        binarySearchTree.preOrderTraversal();

        System.out.println("\nTree in postOrder:");
        binarySearchTree.postOrderTraversal();

        System.out.println("\nTree in level:");
        binarySearchTree.inLevel();


//        binarySearchTree.deleteNode(numbers.get(0));
//        numbers.remove(0);
//
//        binarySearchTree.deleteNode(numbers.get(0));
//        numbers.remove(0);
//
//        binarySearchTree.deleteNode(numbers.get(0));
//        numbers.remove(0);
//
//
//        binarySearchTree.deleteNode(numbers.get(0));
//        numbers.remove(0);
//
//        binarySearchTree.deleteNode(numbers.get(0));
//        numbers.remove(0);
//
//        binarySearchTree.deleteNode(numbers.get(0));
//        numbers.remove(0);
//
//
//        System.out.println("\nNumbers order: "+ numbers.toString());
//
//        System.out.println("\nTree in order: ");
//        binarySearchTree.inOrderTraversal();
//
//        System.out.println("\nTree result preOrder: ");
//        binarySearchTree.preOrderTraversal();
//
//        System.out.println("\nTree in postOrder:");
//        binarySearchTree.postOrderTraversal();
//
//        System.out.println("\nTree in level:");
//        binarySearchTree.inLevel();



    }
}
