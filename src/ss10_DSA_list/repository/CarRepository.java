package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Car;

import java.util.LinkedList;
import java.util.List;

public class CarRepository implements ICarRepository{
    private static List<Car> cars = new LinkedList<>();
    static {
        cars.add(new Car("0984", "Vaio", 1987, "Huy", 4, "car"));
        cars.add(new Car("0994", "Chevrolet", 1920, "Hùng", 4, "car"));
    }
    @Override
    public List<Car> findAll(){
        return cars;
    }
    @Override
    public boolean add(Car car){
        return cars.add(car);
    }
    @Override
    public boolean delete(String id){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i)!=null){
                if (cars.get(i).getNumberOfVehicle().equals(id)){
                    cars.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean find(String id){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i)!=null){
                if (cars.get(i).getNumberOfVehicle().equals(id)){
                    System.out.println(cars.get(i));
                    return true;
                }
            }
        }
        return false;
    }
}
