package m2_demo.vehicle.repo;

import m2_demo.vehicle.model.Motorbike;
import m2_demo.vehicle.util.ReadAndWriteFileVE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MotorRepo implements IMotorRepo{
    private final String MOTOR_FILE = "src/m2_demo/vehicle/data/motorbike.csv";

    @Override
    public List<Motorbike> getAll(){
        List<Motorbike> motorbikeList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileVE.readFileCSV(MOTOR_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                Motorbike motorbike = new Motorbike(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        Integer.parseInt(arr[3]),
                        Double.parseDouble(arr[4]),
                        Integer.parseInt(arr[5])
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
        List<String> list = new ArrayList<>();
        list.add(motorbike.getInfo());
        try {
            ReadAndWriteFileVE.writeListStringToCSV(MOTOR_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Motorbike> motorbikeList = getAll();
        for (Motorbike m : motorbikeList){
            if (m.getIdVehicle().equals(id)){
                motorbikeList.remove(m);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> list = new ArrayList<>();
        for (Motorbike m : motorbikeList){
            list.add(m.getInfo());
        }
        try {
            ReadAndWriteFileVE.writeListStringToCSV(MOTOR_FILE,list,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<Motorbike> findByKeyword(String keyword){
        List<Motorbike> motorbikeList = getAll();
        List<Motorbike> newList = new ArrayList<>();
        for (Motorbike m : motorbikeList){
            if (m.getIdVehicle().equalsIgnoreCase(keyword)){
                newList.add(m);
            } else if (m.getBrand().toLowerCase().contains(keyword.toLowerCase())) {
                newList.add(m);
            }
        }
        return newList;
    }
}
