package Abstraction;

import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        DigitsOnlyFileReader fr = new DigitsOnlyFileReader("message.txt");
        System.out.println(fr.getFilePath());
        System.out.println(fr.readFile());
    }
}
