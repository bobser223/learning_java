//package hw.hw001;

import java.util.Scanner;

public class B01_05 {
    private static void RandomNums(int N, int M){
            for (int i = 0; i < N; i++){
                System.out.println((int)(Math.random()*M));
            }
    }


    public static void main(String[] args) {
        int N, M;
        if (args.length == 2) {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        } else {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            sc.close();
        }
        RandomNums(N, M);
    }
}
