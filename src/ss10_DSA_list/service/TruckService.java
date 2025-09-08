package ss10_DSA_list.service;

import ss10_DSA_list.entity.Truck;
import ss10_DSA_list.repository.ITruckRepository;
import ss10_DSA_list.repository.TruckRepository;

import java.util.List;

public class TruckService implements ITruckService{
    private ITruckRepository truckRepository = new TruckRepository();
    @Override
    public List<Truck> findAll(){
        return truckRepository.findAll();
    }
    @Override
    public boolean add(Truck truck){
        List<Truck> trucks = truckRepository.findAll();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberOfVehicle().equals(truck.getNumberOfVehicle())){
                System.out.println("Id is already exist");
                return false;
            } else break;
        }
        return truckRepository.add(truck);
    }
    @Override
    public boolean delete(String id){
        return truckRepository.delete(id);
    }
    @Override
    public boolean update(Truck truck){
        if (truck==null){
            System.out.println("null list");
            return false;
        }
        if (truck.getNumberOfVehicle()==null||truck.getManufacturer()==null||truck.getLoad()<100){
            System.out.println("fail update");
            return false;
        }
        return truckRepository.update(truck);
    }
    @Override
    public boolean find(String id){
        return truckRepository.find(id);
    }
}
