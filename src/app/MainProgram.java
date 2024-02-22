package app;

import app.FileService.FileReaderService;
import app.FileService.FileWriterService;

import java.io.IOException;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String fileName = scanner.nextLine();
        menu();
        String choose = scanner.nextLine();
        if ( choose.equals("1") ) {
            FileReaderService readerService = new FileReaderService();
            readerService.FileReaderMethod(fileName);
        } else if ( choose.equals("2") ) {
            FileWriterService fileWriterService = new FileWriterService();
            System.out.println("Enter your text: ");
            String myText = scanner.nextLine() + "\r\n";
            FileWriterService.fileWriterMethod(fileName, myText);
        } else {
            System.out.println("wrong inputs");
        }
        scanner.close();
    }

    public static void menu() {
        System.out.println("Choose an action:");
        System.out.println("1. Read the file");
        System.out.println("2. Save to a file");
    }
}
