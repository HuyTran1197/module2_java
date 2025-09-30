package m2_demo.vehicle.service;

import m2_demo.vehicle.model.Motorbike;
import m2_demo.vehicle.repo.IMotorRepo;
import m2_demo.vehicle.repo.MotorRepo;

import java.util.List;

public class MotorService implements IMotorService{
    private static IMotorRepo motorRepo = new MotorRepo();

    @Override
    public List<Motorbike> getAll(){
        return motorRepo.getAll();
    }

    @Override
    public boolean add(Motorbike motorbike){
        for (Motorbike m  : motorRepo.getAll()){
            if (m.getIdVehicle().equals(motorbike.getIdVehicle())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<Motorbike> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        motorbike.setId(id);
        return motorRepo.add(motorbike);
    }

    @Override
    public boolean delete(String id){
        return motorRepo.delete(id);
    }

    @Override
    public List<Motorbike> findByKeyword(String keyword){
        return motorRepo.findByKeyword(keyword);
    }
}
