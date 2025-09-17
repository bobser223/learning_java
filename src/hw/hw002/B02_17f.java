package hw.hw002;

public class B02_17f {

    public static double cos(double x, double eps) {
        if (eps <= 0) throw new IllegalArgumentException("eps має бути > 0");

        double term = 1.0;
        double sum = 0.0;
        int k = 0;

        while (Math.abs(term) > eps) {
            sum += term;
            k++;
            term = -term * x * x / ((2L * k - 1) * (2L * k));
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(cos(0.5, 0.0000000005f));
    }
}
