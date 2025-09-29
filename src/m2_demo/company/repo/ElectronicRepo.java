package m2_demo.company.repo;

import m2_demo.company.model.ElectronicProduct;
import m2_demo.company.util.ReadAndWriteFileCOM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElectronicRepo implements IElectronicRepo{
    private final String ELECTRONIC_FILE = "src/m2_demo/company/data/electronic.csv";

    @Override
    public List<ElectronicProduct> getAll(){
        List<ElectronicProduct> electronicProductList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileCOM.readFileCSV(ELECTRONIC_FILE);
            String[] arr;
            for (String line : stringList){
                arr=line.split(",");
                ElectronicProduct electronicProduct = new ElectronicProduct(Integer.parseInt(arr[0]),
                        arr[1],
                        Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]),arr[4]
                        );
                electronicProductList.add(electronicProduct);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return electronicProductList;
    }

    @Override
    public boolean add(ElectronicProduct electronicProduct){
        List<String> list = new ArrayList<>();
        list.add(electronicProduct.getInfo());
        try {
            ReadAndWriteFileCOM.writeListStringToCSV(ELECTRONIC_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id){
        List<ElectronicProduct> electronicProductList = getAll();
        boolean isSuccessDelete = false;
        for (ElectronicProduct e : electronicProductList){
            if (e.getId()==id){
                electronicProductList.remove(e);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (ElectronicProduct e : electronicProductList){
            stringList.add(e.getInfo());
        }
        try {
            ReadAndWriteFileCOM.writeListStringToCSV(ELECTRONIC_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<ElectronicProduct> findByKeyword(String keyword){
        List<ElectronicProduct> electronicProductList = getAll();
        List<ElectronicProduct> newList = new ArrayList<>();
        for (ElectronicProduct e : electronicProductList){
            if (String.valueOf(e.getId()).equals(keyword)){
                newList.add(e);
            } else if (e.getName().toLowerCase().contains(keyword.toLowerCase())) {
                newList.add(e);
            }
        }
        return newList;
    }
}
