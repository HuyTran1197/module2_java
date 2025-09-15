package ss10_DSA_list.service;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.entity.Truck;
import ss10_DSA_list.repository.ITruckRepository;
import ss10_DSA_list.repository.ManuRepository;
import ss10_DSA_list.repository.TruckRepository;

import java.util.List;

public class TruckService implements ITruckService{
    private ITruckRepository truckRepository = new TruckRepository();
    public static List<Manufacturer> manuList = ManuRepository.getManufacturerList();
    @Override
    public List<Truck> findAll() {
        return truckRepository.findAll();
    }

    @Override
    public boolean add(Truck truck) {
        List<Truck> trucks = truckRepository.findAll();
        if (truck == null) {
            System.out.println("null truck");
            return false;
        }
        for (Truck t : trucks){
            if (t.getNumberOfVehicle().equals(truck.getNumberOfVehicle())){
                System.out.println("the number of vehicle is already exists");
                return false;
            }
        }
        if (truck.getNumberOfVehicle() == null
                || truck.getManufacturer() == null
                || truck.getOwner() == null
                || truck.getLoad() < 500
                ){
            System.out.println("invalid truck data");
            return false;
        }
        List<Truck> list = findAll();

        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        truck.setId(id);
        return truckRepository.add(truck);
    }

    @Override
    public boolean delete(String id) {
        return truckRepository.delete(id);
    }
    @Override
    public boolean update(Truck truck){
        if (truck == null){
            System.out.println("invalid product");
            return false;
        }
        if (truck.getNumberOfVehicle()==null||truck.getManufacturer()==null){
            System.out.println("invalid product");
            return false;
        }
        boolean checkExists = false;
        for (Truck t : truckRepository.findAll()){
            if (t.getNumberOfVehicle().equals(truck.getNumberOfVehicle())){
                checkExists = true;
                int id = t.getId();
                truck.setId(id);
                break;
            }
        }
        if (!checkExists){
            System.out.println("not found number of vehicle to update");
            return false;
        }
        return truckRepository.update(truck);
    }
    @Override
    public Truck find(String id) {
        return truckRepository.find(id);
    }
}
