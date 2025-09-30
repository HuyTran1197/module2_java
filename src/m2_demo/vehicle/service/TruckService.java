package m2_demo.vehicle.service;

import m2_demo.vehicle.model.Truck;
import m2_demo.vehicle.repo.ITruckRepo;
import m2_demo.vehicle.repo.TruckRepo;

import java.util.List;

public class TruckService implements ITruckService{
    private static ITruckRepo truckRepo = new TruckRepo();

    @Override
    public List<Truck> getAll(){
        return truckRepo.getAll();
    }

    @Override
    public boolean add(Truck truck){
        for (Truck t  : truckRepo.getAll()){
            if (t.getIdVehicle().equals(truck.getIdVehicle())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<Truck> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        truck.setId(id);
        return truckRepo.add(truck);
    }

    @Override
    public boolean delete(String id){
        return truckRepo.delete(id);
    }

    @Override
    public List<Truck> findByKeyword(String keyword){
        return truckRepo.findByKeyword(keyword);
    }
}
