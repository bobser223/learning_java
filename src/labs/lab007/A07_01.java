package labs.lab007;

import java.io.*;
import java.util.Arrays;

public class A07_01 {

    public static void main(String[] args) {
        String inp = "src/labs/lab007/input.int32";
        String out = "src/labs/lab007/output.int32";

        int[] array = {55, 0, 1, 2, -1, 9453, -543, 130, 88};

//        wright(out, array);
        System.out.println(Arrays.toString(read(out)));

    }


    public static void wright(String out, int[] array){
        try {
            var f = new DataOutputStream( new FileOutputStream(out));

            for(int x: array){
                f.writeInt(x);

            }

            f.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static int[] read(String in){
        int[] result;
        try {
            var f = new DataInputStream(new FileInputStream(in));

            int size = (int) new File(in).length() / Integer.BYTES;
            result = new int[size];
            for(int i = 0; i < size; i++){
                result[i] = f.readInt();
            }
            f.close();
            return result;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
