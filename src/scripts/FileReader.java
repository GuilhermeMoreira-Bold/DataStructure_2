package src.scripts;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
    LinkedList<Integer> lista = new LinkedList<Integer>();

    public LinkedList<Integer> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
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
