package src.Tree;
import src.scripts.FileReader;
import src.time.DeltaTime;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class TreeTest7 {
    public static void main(String[] args) throws IOException {
        ordenar(2, "Long");
    }

    public static void ordenar(Integer size, String estruturaName) throws IOException {

        HashMap<Integer, String> file = new HashMap<Integer, String>();

        file.put(1, "dados100_mil");
        file.put(5, "dados5");
        file.put(2, "dados100");
        file.put(3, "10mil_positivos");


        AVLTree<Long> avl = new AVLTree<>();
        RedBlackTree<Long> redBlackTree = new RedBlackTree<>();

        HashMap<String, Integer> estrutura = new HashMap<>();
        estrutura.put("Integer", 1);
        estrutura.put("Long", 2);
        estrutura.put("String", 3);

        FileReader text = new FileReader();

        LinkedList<Long> lista = new LinkedList<Long>();

        if (!file.containsKey(size) && estrutura.containsKey(estruturaName)) {
            throw new RuntimeException("Size don't exist");
        }
        lista = text.read("src/data/casos/aleatorio/" + file.get(size) + ".txt", estrutura.get(estruturaName));

        DeltaTime.start();
        for (int i = 0; i < lista.size(); i++) {
            avl.insert( lista.get(i));
        }
        DeltaTime.elapsedTime();
        System.out.println("Elapsed time for avl insert: " + DeltaTime.getElapsedTime());

        DeltaTime.start();
        for (int i = 0; i < lista.size(); i++) {
            redBlackTree.insert(lista.get(i));
        }
        DeltaTime.elapsedTime();
        System.out.println("Elapsed time for redblack insert: " + DeltaTime.getElapsedTime());

        Random rand = new Random();
        HashMap<Long, Integer> avlNumberRepeat = new HashMap<>();
        HashMap<Long, Integer> redBlackNumberRepeat = new HashMap<>();

        for (int j = 0; j < lista.size()/2; j++) {
            long number = rand.nextInt(-9999, 9999);
            if (number % 3 == 0) {
                avl.insert(number);
                redBlackTree.insert(number);
            } else if (number % 5 == 0) {
                avl.deleteElement(number);
                redBlackTree.deleteElement(number);
            } else {
                avlNumberRepeat.put(number, avl.findAllEqualElements(number));
                redBlackNumberRepeat.put(number, redBlackTree.findAllEqualElements(number));
            }
        }
        System.out.println("AVL number repeat count: " + avlNumberRepeat.toString());
        System.out.println("\nRedblack number repeat count: " + redBlackNumberRepeat.toString());

    }
}
