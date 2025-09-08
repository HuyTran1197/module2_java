package ss10_DSA_list.service;

import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.repository.IMotorbikeRepository;
import ss10_DSA_list.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements IMotorbikeService{
    private IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();
    @Override
    public List<Motorbike> findAll(){
        return motorbikeRepository.findAll();
    }
    @Override
    public boolean add(Motorbike motorbike){
        List<Motorbike> motorbikes = motorbikeRepository.findAll();
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getNumberOfVehicle().equals(motorbike.getNumberOfVehicle())){
                System.out.println("Id is already exist");
                return false;
            } else break;
        }
        if (motorbike == null){
            System.out.println("null list");
            return false;
        }
        if (motorbike.getNumberOfVehicle()==null||motorbike.getManufacturer()==null||motorbike.getCapacity()==null){
            return false;
        }
        return motorbikeRepository.add(motorbike);
    }
    @Override
    public boolean delete(String id){
        return motorbikeRepository.delete(id);
    }
    @Override
    public boolean update(Motorbike motorbike){
        if (motorbike == null){
            System.out.println("null list");
            return false;
        }
        if (motorbike.getNumberOfVehicle()==null||motorbike.getManufacturer()==null||motorbike.getCapacity()==null){
            System.out.println("fail update");
            return false;
        }
        return motorbikeRepository.update(motorbike);
    }
    @Override
    public boolean find(String id){
        return motorbikeRepository.find(id);
    }
}
