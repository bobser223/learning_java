package labs.lab008;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class a08_03 {
    public static List<String> readLinesFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        String input = "src/labs/lab008/input02.txt";

        HashMap<String, Integer> map = new HashMap<>();
        List<String> lines = readLinesFromFile(input);
        for (String line : lines) {
            line = line.replace('’', '\'');
            String[] words = line.split(" ");
            for(String word: words)
                if (!map.containsKey(word)){
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);
                }
        }

        System.out.println(map);
    }
}
