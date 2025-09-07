package labs.lab001;
import java.util.Scanner;
import java.util.Locale;

public class t01_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        float num = input.nextFloat();

        System.out.println("fractional part: " +( num - (long)num));
        System.out.println("whole part: " +(long)num);
    }
}
