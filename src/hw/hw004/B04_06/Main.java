package hw.hw004.B04_06;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // створюємо різні предмети екіпіровки з різними параметрами
        Boots b1 = new Boots(12.5, 8);    // вага 12.5, захист 8
        Boots b2 = new Boots(9.3, 5);
        Jacket j1 = new Jacket(15.0, 12);
        Gloves g1 = new Gloves(3.0, 4);
        Pants p1 = new Pants(11.2, 10);
        Gloves g2 = new Gloves(2.8, 7);

        Ammunition[] lst = new Ammunition[]{b1, b2, j1, g1, p1, g2};
        Motorcyclist mot = new Motorcyclist(lst);

        System.out.println("=== motorcyclist equipment ===");
        System.out.println(mot);

        System.out.println("\nTotal equipment price: " + mot.getAmmunitionPrice());

        System.out.println("\n=== Sorting equipment by weight ===");
        mot.sortAmmunitionByWeight();
        System.out.println(mot);

        int left = 5, right = 12;
        System.out.println("\n=== Ammunition with protection factor from "
                + left + " to " + right + " ===");
        List<Ammunition> filtered = mot.getAmmunitionWithProtectionFactorInRange(left, right);
        System.out.println(filtered);
    }
}
