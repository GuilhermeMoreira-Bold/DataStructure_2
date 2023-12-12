package src;

import java.io.IOException;
import java.util.LinkedList;

import src.enums.SortingAlgorithmName;
import src.scripts.CreateFile;
import src.scripts.FileReader;
import src.scripts.WriteFile;
import java.util.HashMap;
import java.util.Random;

import src.time.DeltaTime;

public class app {
    public static void main(String[] args) throws IOException {

        ordenar(SortingAlgorithmName.VOID_AVL_TREE, 100000, "Long");

    }
    public static void ordenar(SortingAlgorithmName sorting,Integer size, String estruturaName) throws IOException {

        HashMap<Integer, String> file = new HashMap<Integer, String>();

        file.put(50, "dados5");
        file.put(10000, "dados10_mil");
        file.put(50000, "dados50_mil");
        file.put(1000, "dados1000");
        file.put(100, "dados100");
        file.put(100000, "dados100_mil");
        file.put(1000001, "100_mil_inverso");
        file.put(1000002, "100_mil_ordenado");
        file.put(500000, "dados500_mil");
        file.put(5000001, "500mil_positivos");
        file.put(10, "10_milhoes");
        file.put(11, "1milhao");
        file.put(1, "5_positivos");
        file.put(2, "10mil_positivos");
        file.put(3, "100mil_positivos");
        file.put(4, "mil_positivos");
        file.put(5, "100mil_positivos");

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
        LinkedList<Long> listaOrdenada = sorting.useAlgorithm(lista);
        DeltaTime.elapsedTime();
        System.out.println("Elapsed time: " + DeltaTime.getElapsedTime());
        CreateFile.createFile(file.get(size) +"_"+ sorting.algorithmName()+"_");
        WriteFile.writeToFile(listaOrdenada);

    }
}
