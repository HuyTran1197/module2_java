package ss12_java_collection_framework;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager{
    Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> productArrayList = new ArrayList<>();

    static {
        productArrayList.add(new Product("lamborghini",999));
        productArrayList.add(new Product("porches",850));
        productArrayList.add(new Product("ferrari",985));
    }
//    public void sortArray(){
//        for (int i = 0; i < productArrayList.size(); i++) {
//            boolean check = true;
//            for (int j = 0; j < productArrayList.size()-i-1; j++) {
//                if (productArrayList.get(j).getPrice()>productArrayList.get(j+1).getPrice()){
//                    Product temp = productArrayList.get(j);
//                    productArrayList.set(j,productArrayList.get(j+1));
//                    productArrayList.set(j+1,temp);
//                    check = false;
//                }
//            }
//            if (check){
//                break;
//            }
//        }
//    }
    public void listProduct(){
        for (int i = 0; i < productArrayList.size(); i++) {
            System.out.println(productArrayList.get(i));
        }
    }
    public void addProduct(String name, int price){
        if (name == null || name.trim().isEmpty() || price<1){
            System.out.println("invalid, added fail");
            return;
        }
        Product productAdd = new Product(name,price);
        productArrayList.add(productAdd);
        System.out.println("added success");
    }
    public void deleteProduct(int id){
        boolean check = false;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i)!=null && productArrayList.get(i).getId() == id){
                check = true;
                System.out.println("do you wanna delete product "+productArrayList.get(i).getName()+" ?");
                String confirm = scanner.nextLine();
                if (confirm.equals("yes")){
                    productArrayList.remove(i);
                    System.out.println("deleted success");
                } else {
                    System.out.println("canceled");
                }
                break;
            }
        }
        if (!check){
            System.out.println("cannot found id");
        }
    }
    public void update(int id, String name, int price){
        if (name == null || name.trim().isEmpty() || price<1){
            System.out.println("invalid, added fail");
            return;
        }
        boolean flag = false;
        for (Product p : productArrayList){
            if (p.getId() == id){
                p.setName(name);
                p.setPrice(price);
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("updated success");
        } else {
            System.out.println("not found id");
        }
    }
    public void find(String name){
        boolean check = false;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getName().equalsIgnoreCase(name)){
                System.out.println(productArrayList.get(i));
                check = true;
            }
        }
        if (!check){
            System.out.println("cannot found name of product");
        }
    }
}
