package hw.hw012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class B12_01 {
    public static void main(String[] args) {
        String[] files = {"src/hw/hw012/input01.txt", "src/hw/hw012/input02.txt", "src/hw/hw012/input03.txt"};
        for (String file : files) {
//            String filePath = (args.length > 0) ? args[0] : "src/hw/hw012/input01.txt";
            String filePath = file;
            try {
                boolean hasDiploma = simulateStudent(filePath);
                System.out.println(hasDiploma ? "YES" : "NO");
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
                StudentVisitor visitor = ActionParser.parse(line);
                student.accept(visitor);
            }

            return student.canGraduate();
        }
    }

    private static String requireLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IllegalArgumentException("Unexpected end of file");
        }
        return line.trim();
    }
}

