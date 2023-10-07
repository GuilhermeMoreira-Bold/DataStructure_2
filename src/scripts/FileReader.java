package src.scripts;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader<T extends Comparable<T>> {
    LinkedList<T> lista = new LinkedList<>();

    public LinkedList<T> read(String filePath, int tipoDaEstruturaDedados) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String Int_line;
            Pattern pattern = Pattern.compile("-?\\d+");
            while ((Int_line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(Int_line);
                while (matcher.find()) {
                    String numeroStr = matcher.group();
                    T numero = (T) parseNumber(numeroStr, tipoDaEstruturaDedados);
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
    private T  parseNumber(String parseNumber, int estruturaNumber){
        if(estruturaNumber == 1){
            return  (T) Integer.valueOf(parseNumber);
        }
        if(estruturaNumber == 2) {
            return (T) Long.valueOf(parseNumber);
        }else {
             throw new RuntimeException("Data structure doesn't exist");
        }
    }

    public static int readIndex(){
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader("src/data/filesIndex.txt"))){
          String int_line;
          int_line = reader.readLine();
          return Integer.parseInt(int_line);
        }catch (Exception e){
            System.out.println("error");
            return Integer.parseInt(null);
        }
    }
}
