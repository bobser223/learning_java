package hw.hw002;

import java.util.Locale;
import java.util.Scanner;

public class B02_01 {

    public static double min(double[] arr){
        double min_val = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min_val){
                min_val = arr[i];
            }
        }
        return min_val;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        int arr_sz = sc.nextInt();
        double[] arr = new double[arr_sz];

        for (int i = 0; i < arr_sz; i++){
            arr[i] = sc.nextDouble();
        }


        System.out.println(min(arr));


        sc.close();

    }
}
