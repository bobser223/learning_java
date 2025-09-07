package labs.lab001;

import java.util.Scanner;

public class t01_02 {
    public static void main(String[] args) {
        double sum = 0;
        for(int i = 0; i < args.length; i++){
            try {
                double value = Double.parseDouble(args[i]); // try to convert
                sum += value;
            } catch (NumberFormatException e) {
                System.out.println(args[i] + " is not a number");
            }

        }
        System.out.println(sum);

    }
}
