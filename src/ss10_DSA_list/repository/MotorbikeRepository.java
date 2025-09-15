package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.ultil.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MotorbikeRepository implements IMotorbikeRepository{
    private final String MOTORBIKE_FILE = "src/ss10_DSA_list/data/motor.csv";

    @Override
    public List<Motorbike> findAll() {
        List<Motorbike> motorbikeList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(MOTORBIKE_FILE);
            String[] arr;
            for (String line : stringList) {
                arr = line.split(",");

                Manufacturer manu = null;
                for (Manufacturer m : ManuRepository.getManufacturerList()) {
                    if (m.getId().equals(arr[2])) {
                        manu = m;
                        break;
                    }
                }

                Motorbike motorbike = new Motorbike(
                        Integer.parseInt(arr[0]),                      // id
                        arr[1],                     // numberOfVehicle
                        manu,                       // manufacturer (object)
                        Integer.parseInt(arr[3]),   // year
                        arr[4],                     // owner
                        arr[5]                      // capacity
                );
                motorbikeList.add(motorbike);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return motorbikeList;
    }

    @Override
    public boolean add(Motorbike motorbike){
        List<String> list = new LinkedList<>();
        list.add(motorbike.getInfoToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(MOTORBIKE_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Motorbike> motorbikeList = findAll();
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (id.equals(motorbikeList.get(i).getNumberOfVehicle())){
                motorbikeList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new LinkedList<>();
        for (int i = 0; i < motorbikeList.size(); i++) {
            stringList.add(motorbikeList.get(i).getInfoToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(MOTORBIKE_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
        }
        return isSuccessDelete;
    }
    @Override
    public boolean update(Motorbike motorbike){
        List<Motorbike> motorbikeList = findAll();
        boolean isSuccessUpdate = false;
        for (int i = 0; i < motorbikeList.size(); i++) {
            if (motorbikeList.get(i).getNumberOfVehicle().equals(motorbike.getNumberOfVehicle())){
                motorbikeList.set(i,motorbike);
                isSuccessUpdate = true;
                break;
            }
        }
        if (isSuccessUpdate){
            List<String> listString = new ArrayList<>();
            for (int i = 0; i < motorbikeList.size(); i++) {
                listString.add(motorbikeList.get(i).getInfoToCSV());
            }
            try {
                ReadAndWriteFile.writeListStringToCSV(MOTORBIKE_FILE,listString,false);
            } catch (IOException e) {
                System.out.println("file write fail");
            }
        }
        return isSuccessUpdate;
    }
    @Override
    public Motorbike find(String id){
        List<Motorbike> motorbikes = findAll();
        for (Motorbike m : motorbikes){
            if (m.getNumberOfVehicle().equals(id)){
                return m;
            }
        }
        return null;
    }
}
