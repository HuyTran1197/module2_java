package m2_demo.practice_java.practice2.repo;
import m2_demo.practice_java.practice2.entity.Product;
import m2_demo.practice_java.practice2.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo{
    private final String PRODUCT_FILE = "src/m2_demo/practice_java/practice2/data/product.csv";

    @Override
    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(PRODUCT_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                Product product = new Product(arr[0],
                        arr[1],
                        Integer.parseInt(arr[2])
                        );
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return products;
    }

    @Override
    public boolean add(Product product){
        List<String> stringList = new ArrayList<>();
        stringList.add(product.getInfoCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(PRODUCT_FILE,stringList,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        List<Product> productList = getAll();
        boolean isFound = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)){
                productList.remove(i);
                isFound = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Product p : productList){
            stringList.add(p.getInfoCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(PRODUCT_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isFound;
    }

    @Override
    public List<Product> findByKeyword(String keyword){
        List<Product> products = getAll();
        List<Product> addList = new ArrayList<>();
        for (Product p : products){
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())){
                Product newList = p;
                addList.add(newList);
            }
        }
        return addList;
    }
}
