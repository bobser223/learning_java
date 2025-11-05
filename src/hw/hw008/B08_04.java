package hw.hw008;

import java.util.Collections;
import java.util.PriorityQueue;

class Point implements Comparable<Point>{
    double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point other){
        return Double.compare(this.distance(new Point(0, 0)), other.distance(new Point(0,0)));
    }
}

public class B08_04 {

    public static void main(String[] args) {
        Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        PriorityQueue<Point> pq = new PriorityQueue<>();

        Collections.addAll(pq, points);

        while (!pq.isEmpty()){
            Point p = pq.poll();
            System.out.println(p + " " + p.distance(new Point(0, 0)));
        }


    }
}
