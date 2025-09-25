package labs.lab003.A03_03;

import java.util.ArrayList;

public class ConnectionManager {
    int counter = 0;
    int n;
    private class Connection {
        private int id;


        public Connection(){
            id = (int)(Math.random() * 1000);
            System.out.println("Connection created with id: " + id);
        }

        public int getId(){
            return id;
        }

        @Override
        public String toString() {
            return "Connection{" +
                    "id=" + id +
                    '}';
        }
    }

    Connection[]  connections;

    public ConnectionManager(){
        this.n = 5;
        int counter = 0;
        connections = new Connection[n];
        for (int i = 0; i < n; i++){
            connections[i] = new Connection();
        }
    }

    Connection get_new_connection(){

        if (this.counter >= this.n){
            throw new RuntimeException("No more connections");
        }

        var c = connections[counter];
        counter++;
        return c;
    }


}
