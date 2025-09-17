package hw.hw001;

import java.util.Scanner;

class B01_01
{
    public static void main(String[] args)
    {
        System.out.print("Введіть ім'я ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.printf("Привіт, %s \n", name);

        sc.close();
    }

}
