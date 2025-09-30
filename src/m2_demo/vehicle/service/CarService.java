package m2_demo.vehicle.service;

import m2_demo.vehicle.model.Car;
import m2_demo.vehicle.repo.CarRepo;
import m2_demo.vehicle.repo.ICarRepo;

import java.util.List;

public class CarService implements ICarService{
    private static ICarRepo carRepo = new CarRepo();

    @Override
    public List<Car> getAll(){
        return carRepo.getAll();
    }

    @Override
    public boolean add(Car car){
        for (Car c : carRepo.getAll()){
            if (c.getIdVehicle().equals(car.getIdVehicle())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<Car> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        car.setId(id);
        return carRepo.add(car);
    }

    @Override
    public boolean delete(String id){
        return carRepo.delete(id);
    }

    @Override
    public List<Car> findByKeyword(String keyword){
        return carRepo.findByKeyword(keyword);
    }
}
