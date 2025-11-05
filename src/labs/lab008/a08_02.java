package labs.lab008;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a08_02 {
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
        Set<String> set = new HashSet<>();
        List<String> lines = readLinesFromFile(input);
        for (String line : lines) {
            line = line.replace('’', '\'');
            String[] words = line.split(" ");
            for(String word: words)
                set.add(word.toLowerCase());
        }

        System.out.println(set);
    }
}
