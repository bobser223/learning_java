package hw.hw003.B03_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private String color;
    private int year;

    private static void qSortByYear(Car[] cars, int left, int right){
        if (left >= right) return;

        int i = left, j = right;
        int pivot = cars[left + (right - left) / 2].year;

        while (i <= j) {
            while (cars[i].year < pivot) i++;
            while (cars[j].year > pivot) j--;
            if (i <= j) {
                Car tmp = cars[i];
                cars[i] = cars[j];
                cars[j] = tmp;       // <- complete the swap
                i++;
                j--;
            }
        }
        if (left < j) qSortByYear(cars, left, j);
        if (i < right) qSortByYear(cars, i, right);
    }

    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.color = "Unknown";
        this.year = 0;
    }

    public Car(String brand, String model, String color, int year){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public Car(Car other) {
        this.brand = other.brand;
        this.model = other.model;
        this.color = other.color;
        this.year = other.year;
    }

    public Car copy() {
        return new Car(this);
    }


    public static Car[] generateCars(int size){
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++){
            cars[i] = new Car(RandomGenerator.getRandBrand(), RandomGenerator.getRandModel(), RandomGenerator.getRandColor(), RandomGenerator.getRandYear(RandomGenerator.first_year_car_appearance, RandomGenerator.curr_year));
        }

        return cars;
    }

    public static Car[] generateCarsSpecificBrandSortedByYear(String brand, int size){
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++){
            cars[i] = new Car(brand, RandomGenerator.getRandModel(), RandomGenerator.getRandColor(), RandomGenerator.getRandYear(RandomGenerator.first_year_car_appearance, RandomGenerator.curr_year));
        }
//        qSortByYear(cars, 0, cars.length-1);
        Arrays.sort(cars);
        return cars;
    }

    public static Car[] generateCarsSpecificModelOlderThanKYears(String model, int size, int n){
        Car[] cars = new Car[size];
        for (int i = 0; i < size; i++){
            cars[i] = new Car(RandomGenerator.getRandBrand(), model, RandomGenerator.getRandColor(), RandomGenerator.getRandYear(RandomGenerator.first_year_car_appearance, RandomGenerator.curr_year - n));
        }
        return cars;
    }


    public static Car[] filterCarsByBrandAndSortByYear(Car[] cars, String brand){
        List<Car> list = new ArrayList<>();
        for (Car car : cars){
            if (car.getBrand().equalsIgnoreCase(brand)){
                list.add(car);
            }
        }
        Car[] result = list.toArray(new Car[0]);
//        if (result.length > 1) {
//            qSortByYear(result, 0, result.length - 1);
//        }

        Arrays.sort(result);
        return result;
    }

    public static Car[] filterCarsByModelAndByExpiredYear(Car[] cars, String model, int n){
        int limitYear = RandomGenerator.curr_year - n;
        List<Car> list = new ArrayList<>();
        for (Car car : cars){
            if (car.getModel().equalsIgnoreCase(model) && car.getYear() < limitYear){
                list.add(car);
            }
        }
        return list.toArray(new Car[0]);
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getYear() { return year; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return year + " " + color + " " + brand + " " + model;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return year == other.year &&
                Objects.equals(brand, other.brand) &&
                Objects.equals(model, other.model) &&
                Objects.equals(color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, year);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.year);
    }


}
