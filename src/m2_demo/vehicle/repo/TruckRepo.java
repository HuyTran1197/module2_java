package m2_demo.vehicle.repo;

import m2_demo.vehicle.model.Truck;
import m2_demo.vehicle.util.ReadAndWriteFileVE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TruckRepo implements ITruckRepo{
    private final String TRUCK_FILE = "src/m2_demo/vehicle/data/truck.csv";

    @Override
    public List<Truck> getAll(){
        List<Truck> truckArrayList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileVE.readFileCSV(TRUCK_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                Truck truck = new Truck(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        Integer.parseInt(arr[3]),
                        Double.parseDouble(arr[4]),
                        Double.parseDouble(arr[5])
                );
                truckArrayList.add(truck);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return truckArrayList;
    }

    @Override
    public boolean add(Truck truck){
        List<String> list = new ArrayList<>();
        list.add(truck.getInfo());
        try {
            ReadAndWriteFileVE.writeListStringToCSV(TRUCK_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Truck> truckList = getAll();
        for (Truck t : truckList){
            if (t.getIdVehicle().equals(id)){
                truckList.remove(t);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> list = new ArrayList<>();
        for (Truck t : truckList){
            list.add(t.getInfo());
        }
        try {
            ReadAndWriteFileVE.writeListStringToCSV(TRUCK_FILE,list,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<Truck> findByKeyword(String keyword){
        List<Truck> truckList = getAll();
        List<Truck> newList = new ArrayList<>();
        for (Truck t : truckList){
            if (t.getIdVehicle().equalsIgnoreCase(keyword)){
                newList.add(t);
            } else if (t.getBrand().toLowerCase().contains(keyword.toLowerCase())) {
                newList.add(t);
            }
        }
        return newList;
    }
}
