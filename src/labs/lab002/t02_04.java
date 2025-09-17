package labs.lab002;

import static java.lang.Math.pow;
import static java.lang.Math.abs;

public class t02_04 {

    public static double log(double x, double eps) {

        double curr = x, prev = 0;
        double x_value = x;
        double minus = 1;
        double k = 1;
        double sum = x;

        while (abs(curr - prev) > eps) {
            prev = curr;
            minus *= -1;
            x_value *= x;
            k++;

            curr = minus * x_value / k;
            sum += curr;






        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(log(0.3, 0.0000000005f));
    }
}
