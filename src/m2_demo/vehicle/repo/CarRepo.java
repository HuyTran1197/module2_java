package m2_demo.vehicle.repo;

import m2_demo.vehicle.model.Car;
import m2_demo.vehicle.util.ReadAndWriteFileVE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements ICarRepo{
    private final String CAR_FILE = "src/m2_demo/vehicle/data/car.csv";

    @Override
    public List<Car> getAll(){
        List<Car> carList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileVE.readFileCSV(CAR_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                Car car = new Car(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        Integer.parseInt(arr[3]),
                        Double.parseDouble(arr[4]),
                        Integer.parseInt(arr[5]),
                        arr[6]
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
        List<String> list = new ArrayList<>();
        list.add(car.getInfo());
        try {
            ReadAndWriteFileVE.writeListStringToCSV(CAR_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<Car> carList = getAll();
        for (Car c : carList){
            if (c.getIdVehicle().equals(id)){
                carList.remove(c);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> list = new ArrayList<>();
        for (Car c : carList){
            list.add(c.getInfo());
        }
        try {
            ReadAndWriteFileVE.writeListStringToCSV(CAR_FILE,list,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<Car> findByKeyword(String keyword){
        List<Car> carList = getAll();
        List<Car> newList = new ArrayList<>();
        for (Car c : carList){
            if (c.getIdVehicle().equalsIgnoreCase(keyword)){
                newList.add(c);
            } else if (c.getBrand().toLowerCase().contains(keyword.toLowerCase())) {
                newList.add(c);
            }
        }
        return newList;
    }
}
