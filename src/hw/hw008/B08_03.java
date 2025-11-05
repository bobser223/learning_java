package hw.hw008;

import java.util.ArrayList;
import java.util.HashMap;

class Graph{
    HashMap<Integer, ArrayList<Integer>> adjList;

    public Graph(){
        adjList = new HashMap<>();
    }

    void addEdge(int v, int w){
        var a = adjList.computeIfAbsent(v, k -> new ArrayList<>());
        if (!a.contains(w)) a.add(w);
        var b = adjList.computeIfAbsent(w, k -> new ArrayList<>());
        if (!b.contains(v)) b.add(v);
    }


    void removeEdge(int v, int w){
        adjList.get(v).remove(Integer.valueOf(w));
        adjList.get(w).remove(Integer.valueOf(v));
    }



    void addVertex(int v){
        adjList.computeIfAbsent(v, k -> new ArrayList<>());
    }

    void removeVertex(int v){
        var neigh = adjList.get(v);
        if (neigh != null) {
            for (int u : neigh) {
                var lu = adjList.get(u);
                if (lu != null) lu.remove(Integer.valueOf(v));
            }
        }
        adjList.remove(v);
    }


    @Override
    public String toString(){
        return adjList.toString();
    }


}

public class B08_03 {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println(g); // очікувано норм структура

        g.removeEdge(1, 3);
        System.out.println(g);

        g.addEdge(2, 5);
        System.out.println(g);

        g.removeVertex(4);
        System.out.println(g);

        g.addVertex(10);
        g.addEdge(10, 1);
        g.addEdge(10, 5);
        System.out.println(g);

        g.removeEdge(2, 5);
        System.out.println(g);

        g.removeVertex(1);
        System.out.println(g);

    }
}
