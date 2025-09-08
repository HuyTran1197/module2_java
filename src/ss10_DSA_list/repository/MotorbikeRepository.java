package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Motorbike;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements IMotorbikeRepository{
    private static List<Motorbike> motorbikes = new ArrayList<>();
    static {
        motorbikes.add(new Motorbike("2357","SH",2000,"Goonch","50HP"));
        motorbikes.add(new Motorbike("2358","ABlade",2000,"Huy","50HP"));
    }
    @Override
    public List<Motorbike> findAll(){
        return motorbikes;
    }
    @Override
    public boolean add(Motorbike motorbike){
        return motorbikes.add(motorbike);
    }
    @Override
    public boolean delete(String id){
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getNumberOfVehicle().equals(id)){
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
                motorbikes.set(i,motorbike);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean find(String id){
        for (int i = 0; i < motorbikes.size(); i++) {
            if (motorbikes.get(i).getNumberOfVehicle().equals(id)){
                System.out.println(motorbikes.get(i));
                return true;
            }
        }
        return false;
    }
}
