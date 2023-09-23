package src.scripts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.LinkedList;

public class CreateFile {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void createFile(String fileName) throws IOException {
        File file = new File("C:\\Users\\gulhe\\IdeaProjects\\DataStructure_2\\src\\results\\" + fileName);

        if (file.exists()) {
            File newFile = new File(manageFilePath(file.getAbsolutePath()));
            newFile.createNewFile();
            CreateFile.file = newFile;

        } else {
            file.createNewFile();
            CreateFile.file = file;
        }
    }

    private static String manageFilePath(String filePath) {

        StringBuffer sb = new StringBuffer(filePath);
        int numberIndex = sb.length() - 6;
        int charAtIncremented = (sb.charAt(numberIndex) + 'O') + 1;
        StringBuilder stringBuilder = new StringBuilder(filePath);
        stringBuilder.insert(numberIndex, charAtIncremented);
        return stringBuilder.toString();
    }
}
