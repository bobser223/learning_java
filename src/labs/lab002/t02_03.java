package labs.lab002;


import java.math.BigInteger;

public class t02_03 {

    public static BigInteger fib_rec(BigInteger n, BigInteger[] arr) {
        if(n.intValue() == 0 || n.intValue() == 1) {
            arr[n.intValue()] = BigInteger.ONE;
        }
        if (arr[n.intValue()] == null ) {
            arr[n.intValue()] = fib_rec(n.subtract(BigInteger.ONE), arr).add(fib_rec(n.subtract(BigInteger.valueOf(2)), arr));
        }

        return arr[n.intValue()];
    }

    public static BigInteger fib_iter(BigInteger n) {
        BigInteger a = BigInteger.ONE, b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger tmp = a;
            a = b;
            b = tmp.add(b);
        }

        return a;
    }

    public static void main(String[] args) {

        BigInteger n = BigInteger.valueOf(9999);

        BigInteger[] arr = new BigInteger[n.intValue() + 1];

        System.out.println("Recursive: " + fib_rec(n, arr));
        System.out.println("Iterative: " + fib_iter(n));


    }
}
