package hw.hw007;

import java.io.*;
import java.util.Arrays;

public class B07_01 {

    public static void main(String[] args) {
        String fileF = "src/hw/hw007/F";
        String fileG = "src/hw/hw007/G";

        wright(fileF, new float[]{1, 2.8F, 3, 4.4F, 5, 6.55F, 7, 8.001F, 9});

        System.out.println(Arrays.toString(read(fileF)));
        task2(fileG, read(fileF), 4);
        System.out.println(Arrays.toString(read(fileG)));


    }
    public static void wright(String out, float[] array){
        try {
            var f = new DataOutputStream( new FileOutputStream(out));

            for(float x: array){
                f.writeFloat(x);

            }

            f.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static float[] read(String in){
        float[] result;
        try {
            var f = new DataInputStream(new FileInputStream(in));

            int size = (int) new File(in).length() / Float.BYTES;
            result = new float[size];
            for(int i = 0; i < size; i++){
                result[i] = f.readFloat();
            }
            f.close();
            return result;

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void task2(String out,float[] vec, int a){
        try {
            var f = new DataOutputStream(new FileOutputStream(out));
            for (var el : vec) {
                if (el > a) {
                    f.writeFloat(el);
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
