package src;

import java.io.IOException;
import java.util.LinkedList;

import src.controller.TimeController;
import src.enums.SortingAlgorithmName;
import src.scripts.CreateFile;
import src.scripts.FileReader;
import src.scripts.WriteFile;
import java.util.HashMap;

import src.time.DeltaTime;

public class app {
    public static void main(String[] args) throws IOException {

        ordenar(SortingAlgorithmName.VOID_QUICK_SORT, 5);


    }
    public static void ordenar(SortingAlgorithmName sorting,Integer size) throws IOException {

        HashMap<Integer, String> file = new HashMap<Integer, String>();


        file.put(5, "dados5");
        file.put(10000, "dados10_mil");
        file.put(50000, "dados50_mil");
        file.put(1000, "dados1000");
        file.put(100, "dados100");
        file.put(100000, "dados100_mil");
        file.put(500000, "dados500_mil");

        FileReader text = new FileReader();

        LinkedList<Integer> lista = new LinkedList<Integer>();

        if(!file.containsKey(size)){
            throw new RuntimeException("Size don't exist");
        }
        lista = text.read("src/data/casos/aleatorio/" + file.get(size) + ".txt");

        DeltaTime.start();
        LinkedList<Integer> listaOrdenada = sorting.useAlgorithm(lista);
        DeltaTime.elapsedTime();

        CreateFile.createFile(file.get(size) +"_"+ sorting.algorithmName()+"_");
        WriteFile.writeToFile(listaOrdenada);

    }
}
