package ss10_DSA_list.service;

import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.repository.IMotorbikeRepository;
import ss10_DSA_list.repository.MotorbikeRepository;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeService implements IMotorbikeService{
    private IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();

    @Override
    public List<Motorbike> findAll(){
        return new ArrayList<>(motorbikeRepository.findAll());
    }

    @Override
    public boolean add(Motorbike motorbike){
        List<Motorbike> motorbikes = motorbikeRepository.findAll();
        if (motorbike == null){
            throw new IllegalArgumentException("object cannot be null");
        }
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getNumberOfVehicle().equals(motorbike.getNumberOfVehicle())){
                throw new IllegalArgumentException("number of vehicle is already exists");
            }
        }
        if (motorbike.getNumberOfVehicle()==null||motorbike.getManufacturer()==null||motorbike.getCapacity()==null){
            throw new IllegalArgumentException("data failed");
        }
        return motorbikeRepository.add(motorbike);
    }

    @Override
    public boolean delete(String numberOfVehicle){
        if (numberOfVehicle==null || numberOfVehicle.isEmpty()){
            throw new IllegalArgumentException("invalid number of vehicle");
        }
        return motorbikeRepository.delete(numberOfVehicle);
    }

    @Override
    public boolean update(Motorbike motorbike){
        if (motorbike == null){
            throw new IllegalArgumentException("object cannot be null");
        }
        if (motorbike.getNumberOfVehicle()==null||motorbike.getManufacturer()==null||motorbike.getCapacity()==null){
            throw new IllegalArgumentException("data failed");
        }
        return motorbikeRepository.update(motorbike);
    }

    @Override
    public Motorbike find(String numberOfVehicle){
        return motorbikeRepository.find(numberOfVehicle);
    }
}
