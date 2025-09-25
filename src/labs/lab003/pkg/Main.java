package labs.lab003.pkg;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int k = 5;
        Fraction[] array = new Fraction[k];
        for (int i = 0; i < k; i++){
            array[i] = Fraction.random();
        }

        Fraction s = Fraction.sum(array);

        System.out.println(Arrays.toString(array));
        System.out.println(s);
    }
}
