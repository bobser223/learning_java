package hw.hw012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class B12_01 {
    public static void main(String[] args) {
        String path = "src/hw/hw012/data/";
        String[] files = {"input01.txt", "input02.txt", "input03.txt", "input04.txt", "input05.txt", "input06.txt",
        "input07.txt", "input08.txt", "input09.txt", "input10.txt", "input11.txt", "input12.txt", "input13.txt",  "input14.txt"};
        for (String file : files) {
            file = path + file;
            String filePath = file;
            try {
                boolean hasDiploma = simulateStudent(filePath);
                System.out.println(hasDiploma ? "YES" : "NO");
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid data in " + filePath + ": " + e.getMessage());
                System.out.println("NO");
            } catch (IOException e) {
                throw new RuntimeException("Unable to read input file: " + filePath, e);
            }
        }
    }

    public static boolean simulateStudent(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Direction direction = Direction.fromString(requireLine(reader));
            int requiredCredits = Integer.parseInt(requireLine(reader).trim());
            int startingMoney = Integer.parseInt(requireLine(reader).trim());

            Student student = new Student(direction, requiredCredits, startingMoney);

            String line;
            while ((line = reader.readLine()) != null) {
                if (student.isExpelled()) {
                    break;
                }
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    StudentVisitor visitor = ActionParser.parse(line);
                    student.accept(visitor);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid action line: \"" + line + "\"", e);
                }
            }

            return student.canGraduate();
        }
    }

    private static String requireLine(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                return line;
            }
        }
        throw new IllegalArgumentException("Unexpected end of file");
    }
}
