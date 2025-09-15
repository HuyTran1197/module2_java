package ss10_DSA_list.service;

import ss10_DSA_list.entity.Car;
import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.repository.CarRepository;
import ss10_DSA_list.repository.ICarRepository;
import ss10_DSA_list.repository.ManuRepository;

import java.util.List;

public class CarService implements ICarService {
    private static ICarRepository carRepository = new CarRepository();
    public static List<Manufacturer> manuList = ManuRepository.getManufacturerList();
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public boolean add(Car car) {
        List<Car> cars = carRepository.findAll();
        if (car == null) {
            System.out.println("null car");
            return false;
        }
        for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getNumberOfVehicle().equals(car.getNumberOfVehicle())) {
                    System.out.println("id already exists");
                    return false;
                }
        }
        if (car.getNumberOfVehicle() == null
                || car.getManufacturer() == null
                || car.getOwner() == null
                || car.getType() == null){
            System.out.println("invalid car data");
            return false;
        }
        List<Car> list = findAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        car.setId(id);
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
        boolean checkExists = false;
        for (Car c : carRepository.findAll()){
            if (c.getNumberOfVehicle().equals(car.getNumberOfVehicle())){
                checkExists = true;
                int id = c.getId();
                car.setId(id);
                break;
            }
        }
        if (!checkExists){
            System.out.println("not found number of vehicle to update");
            return false;
        }
        return carRepository.update(car);
    }

    @Override
    public Car find(String id) {
        return carRepository.find(id);
    }
}
