package hw.hw003.B03_15;

public class Main {
    public static void main(String[] args) {
        Car[] cars = Car.generateCars(100);
        for (Car car : cars){
            System.out.println(car);
        }


        System.out.println("--------------a------------------");
        Car[] cars_brand = Car.generateCarsSpecificBrandSortedByYear("BMW", 10);
        for (Car car : cars_brand){
            System.out.println(car);
        }
        System.out.println("--------------b------------------");
        Car[] cars_model = Car.generateCarsSpecificModelOlderThanKYears("SUV", 10, 5);
        for (Car car : cars_model){
            System.out.println(car);
        }

        System.out.println("------------------a.1----------------");
        Car[] cars_brand_model = Car.filterCarsByBrandAndSortByYear(cars, "BMW");
        for (Car car : cars_brand_model){
            System.out.println(car);
        }
        System.out.println("------------------b.1----------------");
        Car[] cars_model_expired = Car.filterCarsByModelAndByExpiredYear(cars, "SUV", 5);
        for (Car car : cars_model_expired){
            System.out.println(car);
        }



    }
}
