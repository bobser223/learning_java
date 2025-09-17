package hw.hw002;

import java.util.Scanner;

public class B02_12 {

    public static void main(String[] args) {
        byte n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextByte();
        k = sc.nextByte();

        byte mask = (byte) ~(1 << k);
        byte result = (byte) (n & mask);

        System.out.println(result);
    }
}
