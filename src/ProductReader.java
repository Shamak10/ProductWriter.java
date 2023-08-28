import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
// CLASS FOR THE PRODUCT & JFileChooser
public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }
    // HERE IT DISPLAYS FILE DATA
    private static void displayFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("\nID#        Name              Description               Cost");
            System.out.println("========================================================??");
            // LOOP FOR INPUT
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(", ");

                if (data.length == 4) {
                    String id = data[0];
                    String name = data[1];
                    String description = data[2];
                    double cost = Double.parseDouble(data[3]);

                    // Format and display the data
                    System.out.printf("%-10s %-18s %-25s %-5.2f%n",
                            id, name, description, cost);
                }
                // FOR INVALID DATA
                else {
                    System.out.println("Invalid data format: " + line);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
