package hw.hw003.B03_15;

import java.time.Year;
import java.util.Date;
import java.util.Random;

public class RandomGenerator {
    private static final Random rand = new Random();

    private static final String[] COLORS = {
            "Red", "Blue", "Green", "Black", "White", "Yellow", "Orange", "Purple",
            "Pink", "Brown", "Gray", "Silver", "Gold", "Beige", "Turquoise",
            "Cyan", "Magenta", "Lavender", "Maroon", "Olive", "Navy", "Teal",
            "Coral", "Ivory", "Violet", "Charcoal", "Mint", "Peach", "Bronze",
            "Indigo"
    };

    private static final String[] MODELS = {
            "Sedan", "SUV", "Hatchback", "Convertible", "Coupe", "Wagon",
            "Pickup", "Van", "Crossover", "Sports Car", "Luxury Sedan",
            "Compact", "Off-Roader", "Electric", "Hybrid", "Roadster",
            "Mini Truck", "Muscle Car", "Limousine", "Supercar"
    };

    private static final String[] BRANDS = {
            "Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Mercedes-Benz",
            "Audi", "Volkswagen", "Hyundai", "Kia", "Nissan", "Mazda",
            "Subaru", "Porsche", "Jaguar", "Land Rover", "Volvo", "Ferrari",
            "Lamborghini", "Maserati", "Bugatti", "Rolls-Royce", "Bentley",
            "Tesla", "Jeep", "Dodge", "Chrysler", "Peugeot", "Renault", "Fiat"
    };

    public static int first_year_car_appearance = 1886;
    public static int curr_year = Year.now().getValue();

    public static String getRandColor() {
        return COLORS[rand.nextInt(COLORS.length)];
    }

    public static String getRandModel() {
        return MODELS[rand.nextInt(MODELS.length)];
    }

    public static String getRandBrand() {
        return BRANDS[rand.nextInt(BRANDS.length)];
    }

    public static int getRandYear(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min year cannot be greater than max year");
        }
        return rand.nextInt((max - min) + 1) + min;
    }


}
