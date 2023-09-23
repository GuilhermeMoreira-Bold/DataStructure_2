package src.time;

public class ClearConsole {

        // Função para limpar o console no IntelliJ IDEA
 public static void clearConsole() {
            try {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    // Se for Windows, usa um comando para limpar o console
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    // Se for Unix-like (Linux, macOS), usa caracteres de escape ANSI
                    System.out.print("\u001b[H\u001b[2J");
                    System.out.flush();
                }
            } catch (final Exception e) {
                // Lidar com exceções, se ocorrerem
                e.printStackTrace();
            }
        }
}
