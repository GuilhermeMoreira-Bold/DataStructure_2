package src.scripts;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void createFile(String fileName) throws IOException {



        File file = new File("C:\\Users\\gulhe\\IdeaProjects\\DataStructure_2\\src\\results\\" + fileName + getIndex() + ".txt");
        file.createNewFile();
        CreateFile.file = file;


    }
    private static int getIndex() throws IOException {
        int index = (FileReader.readIndex()) + 1;
        WriteFile.writeIndex(index);
        return  index;
    }


}
