package hw.hw004.B04_06;

import hw.hw003.B03_15.Car;

public abstract class Ammunition implements Comparable<Ammunition>{
    private double weight;
    private int protection_factor;
    private int type_factor;


    Ammunition(double weight, int protection_factor, int type_factor){
        this.weight = weight;
        this.protection_factor = protection_factor;
        this.type_factor = type_factor;
    }

    public abstract double getPrice();
    public double getWeight(){ return weight;}
    public int getTypeFactor(){return type_factor;}
    public int getProtectionFactor(){return protection_factor;}

    @Override
    public int compareTo(Ammunition o) {
        return Double.compare(this.weight, o.weight);
    }

    @Override
    public String toString() {
        return "{" +
                "weight=" + weight +
                ", protection_factor=" + protection_factor +
                ", price =" + getPrice() +
                '}';
    }


}
