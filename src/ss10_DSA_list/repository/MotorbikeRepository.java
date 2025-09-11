package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Motorbike;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements IMotorbikeRepository{
    private static List<Motorbike> motorbikes = new ArrayList<>();
    private static int autoId = 0;
    static {
        motorbikes.add(new Motorbike(++autoId,"2357","SH",2000,"Goonch","50HP"));
        motorbikes.add(new Motorbike(++autoId,"2358","ABlade",2000,"Huy","50HP"));
    }
    @Override
    public List<Motorbike> findAll(){
        return motorbikes;
    }
    @Override
    public boolean add(Motorbike motorbike){
        motorbike.setId(++autoId);
        return motorbikes.add(motorbike);
    }
    @Override
    public boolean delete(String numberOfVehicle){
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getNumberOfVehicle().equals(numberOfVehicle)){
                motorbikes.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean update(Motorbike motorbike){
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getNumberOfVehicle().equals(motorbike.getNumberOfVehicle())){
                motorbike.setId(motorbikes.get(i).getId());
                motorbikes.set(i,motorbike);
                return true;
            }
        }
        return false;
    }
    @Override
    public Motorbike find(String numberOfVehicle){
        for (Motorbike m : motorbikes){
            if (m.getNumberOfVehicle().equals(numberOfVehicle)){
                return m;
            }
        }
        return null;
    }
}
