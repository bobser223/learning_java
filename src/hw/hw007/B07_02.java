package hw.hw007;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class Toy{
    String name;
    int price;
    int[] ageLimits;

    @Override
    public String toString() {
        String ages = (ageLimits == null || ageLimits.length < 2)
                ? "null"
                : (ageLimits[0] + "-" + ageLimits[1]);
        return name + "," + price + "," + ages;
    }

    public void serialize(DataOutputStream out) throws IOException {
        writeString(out, name);
        out.writeInt(price);

        if (ageLimits == null) {
            out.writeInt(-1); // маркер null
        } else {
            out.writeInt(ageLimits.length);
            for (int v : ageLimits) out.writeInt(v);
        }
    }

    public static Toy deserialize(DataInputStream in) throws IOException {

        Toy t = new Toy();
        t.name = readString(in);
        t.price = in.readInt();

        int len = in.readInt();
        if (len >= 0) {
            t.ageLimits = new int[len];
            for (int i = 0; i < len; i++) t.ageLimits[i] = in.readInt();
        } else {
            t.ageLimits = null;
        }

        return t;
    }


    private static void writeString(DataOutputStream out, String s) throws IOException {
        if (s == null) {
            out.writeInt(-1);
            return;
        }
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        out.writeInt(bytes.length);
        out.write(bytes);
    }

    private static String readString(DataInputStream in) throws IOException {
        int len = in.readInt();
        if (len < 0) return null;
        byte[] bytes = in.readNBytes(len);
        if (bytes.length != len) throw new EOFException("Unexpected EOF while reading string");
        return new String(bytes, StandardCharsets.UTF_8);
    }


}


public class B07_02 {

    public static void main(String[] args) {
        Toy[] toys = new Toy[12];

        toys[0] = new Toy() {{ name="Lego Star Wars X-Wing"; price=3999; ageLimits=new int[]{9,14}; }};
        toys[1] = new Toy() {{ name="FisherPrice Rattle"; price=249; ageLimits=new int[]{0,2}; }};
        toys[2] = new Toy() {{ name="Barbie Dreamhouse"; price=7999; ageLimits=new int[]{6,12}; }};
        toys[3] = new Toy() {{ name="Nerf Elite Blaster"; price=1599; ageLimits=new int[]{8,15}; }};
        toys[4] = new Toy() {{ name="Hot Wheels Track Builder Set"; price=999; ageLimits=new int[]{5,11}; }};
        toys[5] = new Toy() {{ name="Rubik’s Cube 3x3"; price=499; ageLimits=new int[]{7,99}; }};
        toys[6] = new Toy() {{ name="Monster Truck Toy"; price=799; ageLimits=new int[]{4,9}; }};
        toys[7] = new Toy() {{ name="Chess Wooden Set"; price=1299; ageLimits=new int[]{6,99}; }};
        toys[8] = new Toy() {{ name="Brain Teaser Metal Puzzle"; price=349; ageLimits=new int[]{12,50}; }};
        toys[9] = new Toy() {{ name="Drone Mini FPV"; price=2499; ageLimits=new int[]{14,30}; }};
        toys[10] = new Toy() {{ name="Plastic Blocks Bucket"; price=299; ageLimits=new int[]{1,5}; }};
        toys[11] = new Toy() {{ name="Coding Robot Kit"; price=3499; ageLimits=new int[]{10,18}; }};


        String path = "src/hw/hw007/toys.bin";
        writeToys(path, toys);

        Toy[] back = readToys(path);

        for (Toy t : back) System.out.println(t);

        int age = 10;

        Toy[] suitable = filterByAge(back, age);

        writeToys("src/hw/hw007/toys_filtered.bin", suitable);
    }



    static Toy[] filterByAge(Toy[] toys, int age) {
        List<Toy> list = new ArrayList<>();
        for (Toy t : toys) {
            if (t != null && t.ageLimits != null && t.ageLimits.length >= 2) {
                if (t.ageLimits[0] <= age && age <= t.ageLimits[1]) {
                    list.add(t);
                }
            }
        }
        return list.toArray(new Toy[0]);
    }

    static Toy[] filterByAgeRange(Toy[] toys, int minAge, int maxAge) {
        List<Toy> list = new ArrayList<>();
        for (Toy t : toys) {
            if (t != null && t.ageLimits != null && t.ageLimits.length >= 2) {
                int a1 = t.ageLimits[0], a2 = t.ageLimits[1];
                if (a1 <= maxAge && minAge <= a2) { // overlap
                    list.add(t);
                }
            }
        }
        return list.toArray(new Toy[0]);
    }

    public static void writeToys(String file, Toy[] toys) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

            // cnt
            int n = (toys == null) ? 0 : toys.length;
            out.writeInt(n);


            if (toys != null) {
                for (Toy t : toys) {
                    if (t == null) {
                        out.writeBoolean(true);
                    } else {
                        out.writeBoolean(false);
                        t.serialize(out);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to write toys: " + e.getMessage(), e);
        }
    }


    public static Toy[] readToys(String file) {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {

            int n = in.readInt();
            if (n < 0) throw new IOException("Negative count in file");

            List<Toy> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                boolean isNull = in.readBoolean();
                if (isNull) {
                    list.add(null);
                } else {
                    list.add(Toy.deserialize(in));
                }
            }
            return list.toArray(new Toy[0]);

        } catch (IOException e) {
            throw new RuntimeException("Failed to read toys: " + e.getMessage(), e);
        }
    }
}
