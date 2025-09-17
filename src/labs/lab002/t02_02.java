package labs.lab002;


import java.util.Scanner;

public class t02_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(n ^ (1 << k));



        sc.close();

    }
}
