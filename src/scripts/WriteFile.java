package src.scripts;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import src.controller.Comparacoes;
import src.controller.Movimentacoes;
import src.time.DeltaTime;

public class WriteFile {
    private static final boolean APPEND_TO_FILE = false;

    public static void writeToFile(LinkedList<Long> list) throws IOException {

        FileWriter writer = new FileWriter(CreateFile.getFile().getAbsolutePath(),APPEND_TO_FILE);
        PrintWriter printLine = new PrintWriter(writer);
        String sb = list.toString();

        sb += "\n Quatidade de comparacoes: " + Comparacoes.getVezesComparado();
        sb += "\n Quatidade de movimentacoes: " + Movimentacoes.getVezesMovimentado();
        sb += "\n Tempo gasto na execucao: " + DeltaTime.getElapsedTime();

        writer.append(sb);

        printLine.close();

    }
    public static void  writeIndex(int index) throws IOException {
        FileWriter writer = new FileWriter("src/data/filesIndex.txt", APPEND_TO_FILE);
        PrintWriter printLine = new PrintWriter(writer);
        writer.append(String.valueOf(index));
        printLine.close();
    }
}
