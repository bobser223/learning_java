package hw.hw004.B04_06;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Motorcyclist {
    Ammunition[] ammunition;

    public Motorcyclist(Ammunition[] ammunition){
        this.ammunition = ammunition;
    }

    @Override
    public String toString() {
        return Arrays.toString(ammunition);
    }

    public double getAmmunitionPrice(){
        double sum = 0;
        for (Ammunition ammunition : this.ammunition) {
            sum += ammunition.getPrice();
        }
        return sum;
    }

    public void sortAmmunitionByWeight(){
        Arrays.sort(ammunition);
    }

    public Ammunition[] getAmmunition() {
        return ammunition;
    }

    public List<Ammunition> getAmmunitionWithProtectionFactorInRange(int left, int right){
        List<Ammunition> result = new ArrayList<>();
        for (Ammunition a : this.ammunition) {
            if (a.getProtectionFactor() >= left && a.getProtectionFactor() <= right) {
                result.add(a);
            }
        }
        return result;
    }
}
