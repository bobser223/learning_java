package labs.lab010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.SocketHandler;

public class A10_01_Server {
    public static void main(String[] args){
        int port = 14110;

        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Server running on " + server.getLocalSocketAddress());
            while(true) {

                Socket conn = server.accept();
                System.out.println("Connected to " + conn.getRemoteSocketAddress());


                var reader = new BufferedReader(
                        new InputStreamReader(
                                conn.getInputStream(), StandardCharsets.UTF_8
                        ));

                var writer = new PrintStream(conn.getOutputStream(), true, StandardCharsets.UTF_8);


                int i = 0;
                while (true) {
                    String line = reader.readLine();
                    System.out.println("Received: " + line);
                    if (line == null) break;

                    line = ++i + " " + line;
                    writer.println(line);
                    System.out.println("Sent: " + line);
                }


                conn.close();
                System.out.println("Cient disconnected " + conn.getRemoteSocketAddress());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
