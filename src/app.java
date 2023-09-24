package src;

import java.io.IOException;
import java.util.LinkedList;

import src.controller.TimeController;
import src.enums.SortingAlgorithmName;
import src.scripts.CreateFile;
import src.scripts.FileReader;
import src.scripts.WriteFile;

import src.time.DeltaTime;

public class app {
    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread(new DeltaTime());
        FileReader text = new FileReader();

        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista = text
                .read("src\\data\\casos\\contrario\\100_mil_inverso.txt");

        SortingAlgorithmName algorithmType = SortingAlgorithmName.VOID_QUICK_SORT_RANDOM;

        DeltaTime.start();
        LinkedList<Integer> listaOrdenada = algorithmType.useAlgorithm(lista);

        DeltaTime.elapsedTime();

        CreateFile.createFile("100_mil_CASO_ORDENADO_QUICKSORT_RANDOM_");
        WriteFile.writeToFile(listaOrdenada);

    }
}
