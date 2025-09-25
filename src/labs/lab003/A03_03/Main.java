package labs.lab003.A03_03;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();

        for (int i = 0; i < 6+1; i++){
            System.out.println(cm.get_new_connection());
        }
    }



}

