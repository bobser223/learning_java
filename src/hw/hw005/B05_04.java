package hw.hw005;

import java.io.*;
import java.util.*;

public class B05_04 {
    public static void main(String[] args) {
        getStudents( "students.csv");
        b( "students.csv", "classes.csv" );
        a( "students.csv", "9A", "9A.csv" );
    }

    public static List<List<String>> getStudents(String filename){
        List<List<String>> students = new ArrayList<>();
        try{
            FileReader fr = new FileReader("src/hw/hw005/" + filename);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);

            String header = sc.nextLine();

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] fields = line.split(",");

                students.add(List.of(fields));
            }

            sc.close();
            fr.close();

            return students;
        } catch (java.io.IOException e){
//            throw new RuntimeException(e);
            System.out.println(e);
        }

        return students;
    }

    public static List<List<String>> findStudentsFromClass(String filename, String className){
        var all_students = getStudents(filename);
        var students_from_class = new ArrayList<List<String>>();

        assert all_students != null;

        for (var student : all_students){
            if (student.get(2).equals(className)){
                students_from_class.add(student);
            }
        }

        return students_from_class;

    }

    public static Map<String, Integer> classesCount(String filename){
        var all_students = getStudents(filename);
        var dict = new HashMap<String, Integer>();

        for (var student : all_students){
            if (student.size() > 2) {
                String className = student.get(2);
                dict.put(className, dict.getOrDefault(className, 0) + 1);
            } else {
                System.out.println("Invalid student record: " + student);
            }
        }

        return dict;
    }

    public static void a(String inputFilename, String className, String outputFilename){
        var students = findStudentsFromClass(inputFilename, className);
//        for (var student : students){
//            System.out.println(student);
//        }


        try {
            FileWriter fw = new FileWriter("src/hw/hw005/" + outputFilename);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (var student : students){
                boolean first = true;
                for (int i = 0; i < student.size(); i++) {
                    if (i == 2) continue; // пропускаємо клас
                    if (!first) pw.print(",");
                    pw.print(student.get(i));
                    first = false;
                }
                pw.println();
            }

            pw.close();

        } catch (IOException e) {
            System.out.println(e);
        }


    }


    public static void b(String inputFilename, String outputFilename){
        var dict = classesCount(inputFilename);
//        for (var key : dict.keySet()){
//            System.out.println(key + ": " + dict.get(key));
//        }


        try {
            FileWriter fw = new FileWriter("src/hw/hw005/" + outputFilename);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (var key : dict.keySet()){
                pw.println(key + "," + dict.get(key));
            }

            pw.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
