package hw.hw003.B03_02;

// a x^2 + b x + c = 0


public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
        this.a = this.b = this.c = 0;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(QuadraticEquation other){
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }


    public QuadraticEquation copy(){
        return new QuadraticEquation(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuadraticEquation other = (QuadraticEquation) obj;
        return Double.compare(this.a, other.a) == 0 &&
                Double.compare(this.b, other.b) == 0 &&
                Double.compare(this.c, other.c) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(a, b, c);
    }



    public Root getRoots() {
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    return new Root(true, -1, 0, 0); // infinity roots
                return new Root(false);
            } else {
                return new Root(true, 1, -c / b, -c / b);
            }
        }

        double d = b * b - 4 * a * c;
        if (d < 0) {
            return new Root(false);
        } else {
            double first = (-b + Math.sqrt(d)) / (2 * a);
            double second = (-b - Math.sqrt(d)) / (2 * a);

            if (first == second){
                return new Root(true, 1, first, second);
            } else {
                return new Root(true, 2, first, second);
            }

        }
    }

    public Extremum getExtremum(){
        if (a == 0) {
            return null;
        }

        double x = -b / (2 * a);
        double y = c - Math.pow(b, 2)/(4*a);

        return new Extremum(x, y, a < 0);
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" + a + "x^2 + " + b + "x + " + c + '}';
    }

    public static QuadraticEquation EquationWithMaxRoot(QuadraticEquation equations[]){
        var curr_max = equations[0];
        for (var eq: equations){
            if (!eq.getRoots().getIsRoot()) {
                continue;
            }

            if (curr_max.getRoots().isInfinity()) // in my opinion, infinity roots should be ignored
                continue;
            if (!curr_max.getRoots().getIsRoot()){
                curr_max = eq;
            }
            if (eq.getRoots().getMaxRoot() > curr_max.getRoots().getMaxRoot()){
                curr_max=eq;
            }
        }
        if (!curr_max.getRoots().getIsRoot()){
            return null;
        }
        return curr_max;
    }

    public static QuadraticEquation[] GenerateEquations(int n){
        QuadraticEquation[] equations = new QuadraticEquation[n];
        for (int i = 0; i < n; i++){
            equations[i] = new QuadraticEquation(Math.random() * 10 - 5, Math.random() * 10 - 5, Math.random() * 10 - 5);
        }
        return equations;
    }



}
