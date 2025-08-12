package ss5_accessmodifier_static.thuc_hanh;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    private static Product[] productList = new Product[100];
    static{
        productList[0] = new Product(1,"xiaomi",100);
        productList[1] = new Product(2,"iphone",400);
        productList[2] = new Product(3,"samsung",350);
    }
    public Product[] getAll(){
        return productList;
    }
    public void listProduct(){
        for (int i = 0; i < productList.length; i++) {
            if (productList[i]!=null){
                System.out.println(productList[i]);
            }
        }
    }
    public void addProduct(Product products){
        for (Product product : productList){
            if (product!=null && product.getId() == products.getId()){
                System.out.println("you have entered the same id");
                return;
            }
        }
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null){
                productList[i] = products;
                break;
            }
        }
    }
    public void deleteProduct(int id){
        boolean check = false;
        for (int i = 0; i < productList.length; i++) {
            if (productList[i]!=null && productList[i].getId() == id){
                check = true;
                System.out.println("do you wanna delete product "+productList[i].getName()+" ?");
                String confirm = scanner.nextLine();
                if (confirm.equals("yes")){
                    productList[i] = null;
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
    public void find(int id, String name){
        boolean check = false;
        for (int i = 0; i < productList.length; i++) {
            if (productList[i]!=null && productList[i].getId() == id && productList[i].getName().equals(name)){
                System.out.println(productList[i]);
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("cannot found");
        }
    }
}
