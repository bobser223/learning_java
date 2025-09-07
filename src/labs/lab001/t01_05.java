package labs.lab001;
import java.util.Scanner;

public class t01_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int a = input.nextInt();

        System.out.print("Введіть друге число: ");
        int b = input.nextInt();

        // 1. Кількість розрядів через рядок
        int digitsStrA = String.valueOf(Math.abs(a)).length();
        int digitsStrB = String.valueOf(Math.abs(b)).length();

        int digitsLogA = (a == 0) ? 1 : (int) Math.floor(Math.log10(Math.abs(a))) + 1;
        int digitsLogB = (b == 0) ? 1 : (int) Math.floor(Math.log10(Math.abs(b))) + 1;

        System.out.println("Кількість розрядів (рядки): " + digitsStrA + " та " + digitsStrB);
        System.out.println("Кількість розрядів (логарифм): " + digitsLogA + " та " + digitsLogB);

        input.close();
    }

}
