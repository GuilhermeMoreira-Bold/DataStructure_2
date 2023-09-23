package src;

import java.io.IOException;
import java.util.LinkedList;

import src.controller.TimeController;
import src.enums.SortingAlgorithmName;
import src.scripts.CreateFile;
import src.scripts.TextFileReader;
import src.scripts.WriteFile;

import src.time.DeltaTime;

public class app {
    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread(new DeltaTime());
        TextFileReader text = new TextFileReader();

        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista = text.read("src\\data\\casos\\aleatorio\\dados10_mil.txt");

        SortingAlgorithmName algorithmType = SortingAlgorithmName.VOID_QUICK_SORT;
        t1.start();
        LinkedList<Integer> listaOrdenada = algorithmType.useAlgorithm(lista);
        TimeController.finish();

        CreateFile.createFile("test.txt");
        WriteFile.writeToFile(listaOrdenada);
        // Imprima a lista ordenada
        // for (Integer num : listaOrdenada) {
        // System.out.print(num + " ");
        // }

        // for (int i = 0; i < lista.size(); i++) {
        // System.out.println(lista.get(i));
        // }

    }
}
