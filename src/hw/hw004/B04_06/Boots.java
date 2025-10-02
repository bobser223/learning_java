package hw.hw004.B04_06;

public class Boots extends Ammunition{
    public Boots(double weight, int protection_factor){
        super(weight, protection_factor, 2);
    }
    @Override
    public double getPrice(){
        return getProtectionFactor()*(getTypeFactor());
    }
    @Override
    public String toString(){
        return "Boots "+super.toString();
    }
}
