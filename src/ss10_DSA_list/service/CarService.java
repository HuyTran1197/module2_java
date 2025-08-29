package ss10_DSA_list.service;

import ss10_DSA_list.entity.Car;
import ss10_DSA_list.repository.CarRepository;
import ss10_DSA_list.repository.ICarRepository;

import java.util.List;

public class CarService implements ICarService {
    private ICarRepository carRepository = new CarRepository();

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public boolean add(Car car) {
        List<Car> cars = carRepository.findAll();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) != null) {
                if (cars.get(i).getNumberOfVehicle().equals(car.getNumberOfVehicle())) {
                    System.out.println("id already exists");
                    return false;
                }
            } else break;
        }
        if (car == null) {
            System.out.println("null list");
            return false;
        }
        if (car.getNumberOfVehicle() == null || car.getManufacturer() == null || car.getOwner() == null || car.getType() == null) {
            return false;
        }
        return carRepository.add(car);
    }

    @Override
    public boolean delete(String id) {
        return carRepository.delete(id);
    }
    @Override
    public boolean update(Car car){
        if (car == null){
            System.out.println("invalid product");
            return false;
        }
        if (car.getNumberOfVehicle()==null||car.getManufacturer()==null){
            System.out.println("invalid product");
            return false;
        }
        return carRepository.update(car);
    }
    @Override
    public boolean find(String id) {
        return carRepository.find(id);
    }
}
