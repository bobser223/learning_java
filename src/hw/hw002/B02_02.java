package hw.hw002;

import java.util.Locale;
import java.util.Scanner;

public class B02_02 {

    public static double max(double[] arr){
        double max_val = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max_val){
                max_val = arr[i];
            }
        }
        return max_val;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        int arr_sz = sc.nextInt();
        double[] arr = new double[arr_sz];

        for (int i = 0; i < arr_sz; i++){
            arr[i] = sc.nextDouble();
        }


        System.out.println(max(arr));


        sc.close();

    }
}
