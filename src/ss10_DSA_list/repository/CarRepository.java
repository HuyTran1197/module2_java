package ss10_DSA_list.repository;

import ss10_DSA_list.entity.Car;
import ss10_DSA_list.entity.Manufacturer;
import ss10_DSA_list.ultil.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarRepository implements ICarRepository{
    private final String CAR_FILE = "src/ss10_DSA_list/data/car.csv";

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(CAR_FILE);
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

                Car car = new Car(
                        Integer.parseInt(arr[0]),                      // id
                        arr[1],                     // numberOfVehicle
                        manu,                       // manufacturer (object)
                        Integer.parseInt(arr[3]),   // year
                        arr[4],                     // owner
                        Integer.parseInt(arr[5]),   // seat
                        arr[6]                      // type
                );
                carList.add(car);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return carList;
    }

    @Override
    public boolean add(Car car){
        List<String> list = new LinkedList<>();
        list.add(car.getInfoToCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(CAR_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }
    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Car> carList = findAll();
        for (int i = 0; i < carList.size(); i++) {
            if (id.equals(carList.get(i).getNumberOfVehicle())){
                carList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new LinkedList<>();
        for (Car c : carList){
            stringList.add(c.getInfoToCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(CAR_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
        }
        return isSuccessDelete;
    }
    @Override
    public boolean update(Car car){
        List<Car> carList = findAll();
        boolean isSuccessUpdate = false;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getNumberOfVehicle().equals(car.getNumberOfVehicle())){
                carList.set(i,car);
                isSuccessUpdate = true;
                break;
            }
        }
        if (isSuccessUpdate){
            List<String> listString = new ArrayList<>();
            for (int i = 0; i < carList.size(); i++) {
                listString.add(carList.get(i).getInfoToCSV());
            }
            try {
                ReadAndWriteFile.writeListStringToCSV(CAR_FILE,listString,false);
            } catch (IOException e) {
                System.out.println("file write fail");
            }
        }
        return isSuccessUpdate;
    }
    @Override
    public Car find(String id){
        List<Car> carList = findAll();
        for (Car car : carList){
            if (car.getNumberOfVehicle().equals(id)){
                return car;
            }
        }
        return null;
    }

}
