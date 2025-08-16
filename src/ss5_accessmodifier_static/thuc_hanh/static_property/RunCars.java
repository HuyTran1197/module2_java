package ss5_accessmodifier_static.thuc_hanh.static_property;

public class RunCars {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota 2","Sky active 2");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Toyota 5","Sky active 5");
        System.out.println(Car.numberOfCars);
    }
}
