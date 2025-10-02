package hw.hw004.B04_06;

public class Pants extends Ammunition{
    public Pants(double weight, int protection_factor){
        super(weight, protection_factor, 3);
    }
    @Override
    public double getPrice(){
        return getProtectionFactor()*(getTypeFactor());
    }
    @Override
    public String toString(){
        return "Pants "+ super.toString();
    }
}
