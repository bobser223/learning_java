package labs.lab002;

import java.util.Scanner;

public class t02_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr_sz = sc.nextInt();

        int[] arr = new int[arr_sz];
        for (int i = 0; i < arr_sz; i++) {
            arr[i] = sc.nextInt();
        }


        int sum = 0;
        for(var el: arr){
            if (el % k == 0)
                sum++;
        }

        System.out.println(sum);

        sc.close();
    }
}
