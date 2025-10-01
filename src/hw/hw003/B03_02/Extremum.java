package hw.hw003.B03_02;

import java.util.Objects;

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

    public Extremum(){
        this(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, false, false);
    }

    public Extremum(Extremum other){
        this(other.x, other.y, other.max, other.min);
    }

    public Extremum copy(){
        return new Extremum(this);
    }

    @Override
    public String toString() {
        if (max) return "Extremum{max at (" + x + ", " + y + ")}";
        if (min) return "Extremum{min at (" + x + ", " + y + ")}";
        return "Extremum{undefined}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Extremum other = (Extremum) obj;
        return Double.compare(x, other.x) == 0 &&
                Double.compare(y, other.y) == 0 &&
                max == other.max &&
                min == other.min;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, max, min);
    }

    public Extremum(double x, double y, boolean max){
        this(x, y, max, !max);
    }
}
