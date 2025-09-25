package labs.lab003.pkg;

public class Fraction {

    private int m;
    private int n;

    public Fraction(int num, int den) {
        if (den <= 0)
            throw new RuntimeException("Denominator must be positive");
        this.m = num;
        this.n = den;
        reduce();
    }

    public Fraction() {
        this(0, 1);
    }

    public Fraction(Fraction other){
        this.m = other.m;
        this.n = other.n;
    }

    public static int gcd(int a, int b){
        while (b > 0){
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    private void reduce(){
        int g = gcd(Math.abs(m), n);
        m /= g;
        n /= g;
    }


    @Override
    public String toString() {
        return m + "/" + n;
//        return super.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Fraction){
            Fraction other = (Fraction) obj;
            return this.m * other.n == this.n * other.m;
        }
        return false;
    }

    public boolean equels(Fraction other){
        return m == other.m && n == other.n;
    }

    public Fraction add(Fraction other){
        return new Fraction(m * other.n + n * other.m, n * other.n);
    }

    public static Fraction sum(Fraction[] array){
        Fraction s = new Fraction();
        for (Fraction f : array){
            s = s.add(f);
        }
        return s;
    }


    public static Fraction random(){
        int n =(int) (Math.random() * 50 - 100);
        int d = (int) (Math.random() * 50 + 1);
        return new Fraction(n, d);
    }
}
