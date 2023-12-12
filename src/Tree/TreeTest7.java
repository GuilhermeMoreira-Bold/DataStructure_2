package src.Tree;

import src.enums.SortingAlgorithmName;
import src.scripts.CreateFile;
import src.scripts.FileReader;
import src.scripts.WriteFile;
import src.time.DeltaTime;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class TreeTest7 {
    public static void main(String[] args) throws IOException {
        ordenar(100000, "Long");
    }
    public static void ordenar(Integer size, String estruturaName) throws IOException {

        HashMap<Integer, String> file = new HashMap<Integer, String>();

        file.put(100000, "dados100_mil");
        file.put(5, "dados5");
        file.put(2,"5_positivos");


        AVLTree<Long> avl = new AVLTree<>();
        RedBlackTree redBlackTree = new RedBlackTree();

        HashMap<String, Integer> estrutura = new HashMap<>();
        estrutura.put("Integer",1);
        estrutura.put("Long", 2);
        estrutura.put("String", 3);

        FileReader text = new FileReader();

        LinkedList<Long> lista = new LinkedList<Long>();

        if(!file.containsKey(size) && estrutura.containsKey(estruturaName)){
            throw new RuntimeException("Size don't exist");
        }
        lista = text.read("src/data/casos/aleatorio/" + file.get(size) + ".txt", estrutura.get(estruturaName));

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
        for(int j = 0; j < lista.size()/2; j++){
            long number = rand.nextInt(-9999, 9999);
            if((number %= 3) == 0){
                avl.insert(number);
                redBlackTree.insert(number);
            }
            if((number %= 5) == 0) {
                avl.deleteElement(number);
                redBlackTree.deleteNode(number);
            }
            System.out.println("All equal elements in AVL: " + avl.findAllEqualElements(number));
            System.out.println("All equal elements in redBlack: " + redBlackTree.findAllEqualElements(number));

        }

    }
}
