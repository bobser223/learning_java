package hw.hw010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {


    public static void main(String[] args) {
        int port = 1234;
        try(ServerSocket ss = new ServerSocket(port)){
            handleClient(ss);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void handleClient(ServerSocket server) {
        try(Socket connection = server.accept()){


            var reader = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream(), StandardCharsets.UTF_8
                    ));

            var writer = new PrintStream(connection.getOutputStream(), true, StandardCharsets.UTF_8);

            int i = 1;
            while(true) {
                String line = reader.readLine();
                if (line == null) break;

                System.out.println("Received: " + line);

                String largestWord = findLargestWord(line);

                writer.println(largestWord);
                writer.flush();

                System.out.println("Sent: " + largestWord);
                i++;
            }




        } catch ( Exception e){
            System.out.println("Error: " + e.getMessage());
        }


    }


    public static String findLargestWord(String line) {
        String[] words = line.split(" ");
        String largest = "";
        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }
        return largest;
    }
}













