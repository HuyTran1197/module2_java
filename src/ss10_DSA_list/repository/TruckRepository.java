package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements ITruckRepository{
    private static List<Truck> trucks = new ArrayList<>();
    static {
        trucks.add(new Truck("1357","Mercedes",1850,"Andy",1500));
        trucks.add(new Truck("1387","Hyundai",1850,"Jack",1700));
    }
    @Override
    public List<Truck> findAll(){
        return trucks;
    }
    @Override
    public boolean add(Truck truck){
        return trucks.add(truck);
    }
    @Override
    public boolean delete(String id){
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberOfVehicle().equals(id)){
                trucks.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean update(Truck truck){
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberOfVehicle().equals(truck.getNumberOfVehicle())){
                trucks.set(i,truck);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean find(String id){
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getNumberOfVehicle().equals(id)){
                System.out.println(trucks.get(i));
                return true;
            }
        }
        return false;
    }
}
