package labs.lab008;

import javax.print.DocFlavor;
import java.util.PriorityQueue;

public class a08_05 {
    public static void main(String[] args) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();

        for (int i = 0; i < 10; i++){
            pq.add(new Pair<Integer, Integer>(i, i*i));
        }
        pq.add(new Pair<Integer, Integer>(5, 26));
        pq.add(new Pair<>(5, 24));

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }




}
