package m2_demo.furama_resort.service;

import m2_demo.furama_resort.model.Facility;
import m2_demo.furama_resort.repository.FacilityRepo;
import m2_demo.furama_resort.repository.IFacilityRepo;

import java.util.List;

public class FacilityService implements IFacilityService{
    private static IFacilityRepo facilityRepo = new FacilityRepo();

    @Override
    public List<Facility> getAll(){
        return facilityRepo.getAll();
    }

    @Override
    public boolean add(Facility facility){
        if (facility==null){
            return false;
        }
        if (facility.getIdService()==null
                ||facility.getNameService()==null
                ||facility.getArea()<30
                ||facility.getCost()<0
                ||facility.getMax()<0
                ||facility.getRentType()==null
        ){
            return false;
        }
        for (Facility f : facilityRepo.getAll()){
            if (f.getIdService().equals(facility.getIdService())){
                System.out.println("id is already exists");
                return false;
            }
        }
        return facilityRepo.add(facility);
    }

    @Override
    public boolean edit(Facility facility){
        if (facility==null){
            return false;
        }
        if (facility.getIdService()==null
                ||facility.getNameService()==null
                ||facility.getArea()<30
                ||facility.getCost()<0
                ||facility.getMax()<0
                ||facility.getRentType()==null
        ){
            return false;
        }
        boolean isExists = false;
        for (Facility f : facilityRepo.getAll()){
            if (f.getIdService().equals(facility.getIdService())){
                isExists = true;
                break;
            }
        }
        if (!isExists){
            System.out.println("not found id to edit facility");
            return false;
        }
        return facilityRepo.edit(facility);
    }
}
