package hw.hw004.B04_06;

public class Gloves extends Ammunition{
    public Gloves(double weight, int protection_factor){
        super(weight, protection_factor, 1);
    }
    @Override
    public double getPrice(){
        return getProtectionFactor()*(getTypeFactor());
    }
    @Override
    public String toString(){
        return "Gloves " + super.toString();
    }
}
