package ss10_DSA_list.service;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.repository.*;

import java.util.List;

public class MotorbikeService implements IMotorbikeService{
    private static IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();
    public static List<Manufacturer> manuList = ManuRepository.getManufacturerList();
    @Override
    public List<Motorbike> findAll() {
        return motorbikeRepository.findAll();
    }

    @Override
    public boolean add(Motorbike motorbike) {
        List<Motorbike> motorbikes = motorbikeRepository.findAll();
        if (motorbike == null) {
            System.out.println("null motorbike");
            return false;
        }
        for (Motorbike m : motorbikes){
            if (m.getNumberOfVehicle().equals(motorbike.getNumberOfVehicle())){
                System.out.println("the number of vehicle is already exists");
                return false;
            }
        }
        if (motorbike.getNumberOfVehicle() == null
                || motorbike.getManufacturer() == null
                || motorbike.getOwner() == null
                || motorbike.getCapacity() == null){
            System.out.println("invalid motorbike data");
            return false;
        }
        List<Motorbike> list = findAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        motorbike.setId(id);
        return motorbikeRepository.add(motorbike);
    }

    @Override
    public boolean delete(String id) {
        return motorbikeRepository.delete(id);
    }
    @Override
    public boolean update(Motorbike motorbike){
        if (motorbike == null){
            System.out.println("invalid product");
            return false;
        }
        if (motorbike.getNumberOfVehicle()==null||motorbike.getManufacturer()==null){
            System.out.println("invalid product");
            return false;
        }
        boolean checkExists = false;
        for (Motorbike m : motorbikeRepository.findAll()){
            if (m.getNumberOfVehicle().equals(motorbike.getNumberOfVehicle())){
                checkExists = true;
                int id = m.getId();
                motorbike.setId(id);
                break;
            }
        }
        if (!checkExists){
            System.out.println("not found number of vehicle to update");
            return false;
        }
        return motorbikeRepository.update(motorbike);
    }
    @Override
    public Motorbike find(String id) {
        return motorbikeRepository.find(id);
    }
}
