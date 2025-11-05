package labs.lab008;

public class Pair<T1 extends Comparable<T1>, T2 extends Comparable<T2>>
        implements Comparable<Pair<T1, T2>>{


    public T1 first;
    public T2 second;

    public Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }



    @Override
    public int compareTo(Pair<T1, T2> o) {
        if (first.compareTo(o.first) != 0){
            return first.compareTo(o.first);
        }
        return second.compareTo(o.second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

}

