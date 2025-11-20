package labs.lab010;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class A10_01_Client {
    public static void main(String[] args) throws IOException {
        int port = 14110;
        String host = "localhost";

        String fileInp = "src/labs/lab010/input.txt";
        String fileOut = "src/labs/lab010/output.txt";


        Socket sock = new Socket(host, port);
        System.out.println("Connected to " + sock.getRemoteSocketAddress());

        var reader = new BufferedReader(
                new InputStreamReader(
                sock.getInputStream(), StandardCharsets.UTF_8
        ));

        var writer = new PrintStream(sock.getOutputStream(), true, StandardCharsets.UTF_8);

        var fInp = new BufferedReader(new FileReader(fileInp, StandardCharsets.UTF_8));
        var fOut = new BufferedWriter(new FileWriter(fileOut, StandardCharsets.UTF_8));

        while(true) {
            String line = fInp.readLine();
            if (line == null) break;
            writer.println(line);
            System.out.println("Sent: " + line);
            line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
            fOut.write(line + "\n");
        }

        fInp.close();
        fOut.close();
        sock.close();
        System.out.println("disconnected form: " + sock.getRemoteSocketAddress());

    }
}
