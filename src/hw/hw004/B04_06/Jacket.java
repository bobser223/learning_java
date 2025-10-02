package hw.hw004.B04_06;

public class Jacket extends Ammunition{
    public Jacket(double weight, int protection_factor){
        super(weight, protection_factor, 4);
    }
    @Override
    public double getPrice(){
        return getProtectionFactor()*(getTypeFactor());
    }
    @Override
    public String toString(){
        return "Jacket " + super.toString();
    }
}
