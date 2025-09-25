package hw.hw003.B03_02;

public class Extremum {
    double x, y;
    boolean max;
    boolean min;

    public Extremum(double x, double y, boolean max, boolean min){
        this.x = x;
        this.y = y;
        this.max = max;
        this.min = min;
    }

    public Extremum(double x, double y, boolean max){
        this(x, y, max, !max);
    }
}
