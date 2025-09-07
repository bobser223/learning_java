//package hw.hw001;

import java.util.Scanner;

import static java.lang.Math.cbrt;

public class B01_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.printf("%.4f%n \n", cbrt(a * b * c)); //TODO: check is this correct


        sc.close();
    }
}
