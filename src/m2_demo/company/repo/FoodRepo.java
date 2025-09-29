package m2_demo.company.repo;

import m2_demo.company.model.FoodProduct;
import m2_demo.company.util.ReadAndWriteFileCOM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodRepo implements IFoodRepo{
    private final String FOOD_FILE = "src/m2_demo/company/data/food.csv";

    @Override
    public List<FoodProduct> getAll(){
        List<FoodProduct> foodProductList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFileCOM.readFileCSV(FOOD_FILE);
            String[] arr;
            for (String line : stringList){
                arr=line.split(",");
                FoodProduct foodProduct = new FoodProduct(Integer.parseInt(arr[0]),
                        arr[1],
                        Double.parseDouble(arr[2]),
                        arr[3],
                        arr[4]
                        );
                foodProductList.add(foodProduct);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return foodProductList;
    }

    @Override
    public boolean add(FoodProduct foodProduct){
        List<String> list = new ArrayList<>();
        list.add(foodProduct.getInfo());
        try {
            ReadAndWriteFileCOM.writeListStringToCSV(FOOD_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id){
        boolean isSuccessDelete = false;
        List<FoodProduct> foodProductList = getAll();
        for (FoodProduct f : foodProductList){
            if (f.getId()==id){
                foodProductList.remove(f);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> list = new ArrayList<>();
        for (FoodProduct f : foodProductList){
            list.add(f.getInfo());
        }
        try {
            ReadAndWriteFileCOM.writeListStringToCSV(FOOD_FILE,list,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<FoodProduct> findByKeyword(String keyword){
        List<FoodProduct> foodProductList = getAll();
        List<FoodProduct> newList = new ArrayList<>();
        for (FoodProduct f : foodProductList){
            if (String.valueOf(f.getId()).equals(keyword)){
                newList.add(f);
            } else if (f.getName().toLowerCase().contains(keyword.toLowerCase())) {
                newList.add(f);
            }
        }
        return newList;
    }
}
