package src.scripts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileReader {
    LinkedList<Integer> lista = new LinkedList<Integer>();

    public LinkedList<Integer> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String Int_line;
            Pattern pattern = Pattern.compile("-?\\d+");
            while ((Int_line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(Int_line);
                while (matcher.find()) {
                    String numeroStr = matcher.group();
                    int numero = Integer.parseInt(numeroStr);
                    lista.add(numero);
                }
            }
            reader.close();
            return this.lista;

        } catch (Exception e) {
            System.out.println("error");
            return null;
        }
    }
}
