package labs.lab008;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class a08_01 {

    public static List<String> readLinesFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void writeLinesToFile(List<String> lines, String filePath) {
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String inputFile = "src/labs/lab008/input01.txt";
        String outputFile = "src/labs/lab008/output01.txt";

        List<String> lines = readLinesFromFile(inputFile).reversed();
        writeLinesToFile(lines, outputFile);

    }
}
