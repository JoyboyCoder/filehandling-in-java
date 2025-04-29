package Files;

import java.io.*;
import java.util.*;

public class FileHandle {
   
    public static void main(String[] args) {
        try {
       

        while (true) {
            System.out.println("Hello guys ,This is for understanding of Filehandling");
            Scanner sc = new Scanner(System.in);
            System.out.println("0-> Exit");
            System.out.println("1-> Create a file and add detail");
            System.out.println("2-> Delete a file");
            System.out.println("3-> Read a file");
            System.out.println("4-> Delete a Line from a file");
            System.out.println("Enter the choice ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter the FileName like file.txt");
                    String filename = sc.nextLine();
                    createNewFile(filename);
                    break;
                case 2:
                    System.out.println("Enter the FileName");
                    String filename1;
                    filename1 = sc.nextLine();
                    deleteFile(filename1);
                    break;

                case 3:
                    System.out.println("Enter the FileName");
                    String filename2;
                    filename2 = sc.nextLine();
                    readFile(filename2);
                    break;

                case 4:
                    System.out.println("Enter the FileName");
                    String filename3;
                    filename3 = sc.nextLine();
                    System.out.println("Enter the Number of line that you want to delete");
                    int lineNumber;
                    lineNumber = sc.nextInt();
                    deleteLine(filename3, lineNumber);
                    break;

                default:
                    System.out.println("Invalid Option");
                    break;
            }
            Thread.sleep(3000); 
            
        } 
        
            

        }
        catch (Exception e) {System.out.println(e);}

    }

    public static void createNewFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);
            System.err.println("Enter the line");
            String s = sc.nextLine();
            bw.write(s);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filename) {
        File file = new File(filename);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void readFile(String filename) {
        String file = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            file = br.readLine();
            while (file != null) {
                System.out.println(file + " ");
                file = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void deleteLine(String filename, int lineNumber) {

        try {
            List<String> lines = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine;
            int currentLineNumber = 1;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLineNumber != lineNumber) {
                    lines.add(currentLine);
                }
                currentLineNumber++;
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();

            System.out.println("Line " + lineNumber + " deleted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
