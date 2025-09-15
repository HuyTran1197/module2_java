package ss10_DSA_list.repository;


import ss10_DSA_list.entity.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class ManuRepository {
    public static List<Manufacturer> manufacturerList = new ArrayList<>();

    static {
        manufacturerList.add(new Manufacturer("M001","Honda","Japan"));
        manufacturerList.add(new Manufacturer("M002","Yamaha","Japan"));
        manufacturerList.add(new Manufacturer("M003","Ford","USA"));
        manufacturerList.add(new Manufacturer("M004","Hyundai","Korea"));
    }
     public static List<Manufacturer> getManufacturerList(){
        return manufacturerList;
     }
}
