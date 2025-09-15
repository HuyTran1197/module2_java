package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.entity.Motorbike;
import ss10_DSA_list.entity.Truck;
import ss10_DSA_list.ultil.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TruckRepository implements ITruckRepository{
    private final String TRUCK_FILE = "src/ss10_DSA_list/data/truck.csv";

    @Override
    public List<Truck> findAll() {
        List<Truck> truckList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(TRUCK_FILE);
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

                Truck truck = new Truck(
                        Integer.parseInt(arr[0]),                      // id
                        arr[1],                     // numberOfVehicle
                        manu,                       // manufacturer (object)
                        Integer.parseInt(arr[3]),   // year
                        arr[4],                     // owner
                        Double.parseDouble(arr[5])  // load
                );
                truckList.add(truck);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return truckList;
    }

    @Override
    public boolean add(Truck truck){
        List<String> list = new LinkedList<>();
        list.add(truck.getInfoToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(TRUCK_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Truck> truckList = findAll();
        for (int i = 0; i < truckList.size(); i++) {
            if (id.equals(truckList.get(i).getNumberOfVehicle())){
                truckList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new LinkedList<>();
        for (Truck truck : truckList){
            stringList.add(truck.getInfoToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(TRUCK_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
        }
        return isSuccessDelete;
    }
    @Override
    public boolean update(Truck truck){
        List<Truck> truckList = findAll();
        boolean isSuccessUpdate = false;
        for (int i = 0; i < truckList.size(); i++) {
            if (truckList.get(i).getNumberOfVehicle().equals(truck.getNumberOfVehicle())){
                truckList.set(i,truck);
                isSuccessUpdate = true;
                break;
            }
        }

        if (isSuccessUpdate){
            List<String> listString = new ArrayList<>();
            for (int i = 0; i < truckList.size(); i++) {
                listString.add(truckList.get(i).getInfoToCSV());
            }
            try {
                ReadAndWriteFile.writeListStringToCSV(TRUCK_FILE,listString,false);
            } catch (IOException e) {
                System.out.println("file write fail");
            }
        }
        return isSuccessUpdate;
    }
    @Override
    public Truck find(String id){
        List<Truck> trucks = findAll();
        for (Truck t : trucks){
            if (t.getNumberOfVehicle().equals(id)){
                return t;
            }
        }
        return null;
    }
}
