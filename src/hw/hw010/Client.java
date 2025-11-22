package hw.hw010;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args){
        int port = 1234;
        String host = "localhost";

        String inputFile = "src/hw/hw010/input.txt";
        try(Socket sock = new Socket(host, port);
            var reader = new BufferedReader(
                    new InputStreamReader(
                            sock.getInputStream(), StandardCharsets.UTF_8
                    ));
            var fileReader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
            var writer = new PrintStream(sock.getOutputStream(), true, StandardCharsets.UTF_8)
            ){

            String line;
            while((line = fileReader.readLine()) != null){
                writer.println(line);
                System.out.println("Sent: " + line);

                line = reader.readLine();
                if (line == null) break;
                System.out.println("largest word = "+line);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
