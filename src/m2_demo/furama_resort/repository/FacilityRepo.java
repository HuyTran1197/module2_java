package m2_demo.furama_resort.repository;

import m2_demo.furama_resort.model.Facility;
import m2_demo.furama_resort.model.House;
import m2_demo.furama_resort.model.Room;
import m2_demo.furama_resort.model.Villa;

import java.util.*;

public class FacilityRepo implements IFacilityRepo{
    private static List<Facility> facilityList = new ArrayList<>();

    static {
        facilityList.add(new Villa("SVVL-0987","Villa",100,2500000,10,"Days","Vip",31,3));
        facilityList.add(new House("SVHO-0524","House",60,2000000,5,"Years","Normal",3));
        facilityList.add(new Room("SVRO-0357","Room",31,500000,2,"Days","Breakfast"));
    }

    @Override
    public List<Facility> getAll(){
        return facilityList;
    }

    @Override
    public boolean add(Facility facility){
        facilityList.add(facility);
        return true;
    }

    @Override
    public boolean edit(Facility facility){
        for (int i = 0; i < facilityList.size(); i++) {
            if (facilityList.get(i).getIdService().equals(facility.getIdService())){
                facilityList.set(i,facility);
                return true;
            }
        }
        return false;
    }
}
