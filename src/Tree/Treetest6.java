package src.Tree;

import src.scripts.FileReader;
import src.time.DeltaTime;

import java.util.LinkedList;
import java.util.Random;

public class Treetest6 {
    public static void main(String[] args) {
        AVLTree<Long> avl = new AVLTree<>();
        RedBlackTree redBlackTree = new RedBlackTree();
        FileReader text = new FileReader();

        LinkedList<Long> lista = new LinkedList<Long>();


        lista = text.read("src/data/casos/aleatorio/dados100_mil.txt", 2);

        DeltaTime.start();
        for(int i = 0; i < lista.size(); i ++){
            long number = lista.get(i);
            avl.insert(number);
            redBlackTree.insert(number);
        }
        DeltaTime.elapsedTime();
        System.out.println("Elapsed time for avl insert: " + DeltaTime.getElapsedTime());

        DeltaTime.start();
        for(int i = 0; i < lista.size(); i ++){
            redBlackTree.insert(lista.get(i));
        }
        DeltaTime.elapsedTime();
        System.out.println("Elapsed time for redblack insert: " + DeltaTime.getElapsedTime());

        Random rand = new Random();
        for(int j = 0; j < 50_000; j++){
            long number = rand.nextInt(-9999, 9999);
            if((number %= 3) == 0){
               avl.insert(number);
               redBlackTree.insert(number);
            }
            if((number %= 5) == 0) {
                avl.deleteElement(number);
                redBlackTree.deleteElement(number);
            }
            System.out.println("All equal elements in AVL: " + avl.findAllEqualElements(number));
            System.out.println("All equal elements in redBlack: " + redBlackTree.findAllEqualElements(number));

        }
    }
}
