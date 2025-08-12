package ss5_accessmodifier_static.thuc_hanh;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("---Smartphone Product Manager");
            System.out.println("Function: "+
                    "\n 1. List"+
                    "\n 2. Add"+
                    "\n 3. Delete"+
                    "\n 4. Find"+
                    "\n 5. Out"
            );
            System.out.println("Choose function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("List");
                    productManager.listProduct();
                    break;
                case 2:
                    System.out.println("Add");
                    Product productAdd = new Product();
                    System.out.print("enter id: ");
                    productAdd.setId(Integer.parseInt(scanner.nextLine()));
                    System.out.print("enter name: ");
                    productAdd.setName(scanner.nextLine());
                    System.out.print("enter price: ");
                    productAdd.setPrice(Double.parseDouble(scanner.nextLine()));
                    productManager.addProduct(productAdd);
                    break;
                case 3:
                    System.out.println("Delete");
                    System.out.print("enter the product id need to delete: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    productManager.deleteProduct(idDel);
                    break;
                case 4:
                    System.out.println("Find");
                    System.out.print("enter the product id need to find: ");
                    int idFind = Integer.parseInt(scanner.nextLine());
                    System.out.print("enter the product name need to find: ");
                    String nameFind = scanner.nextLine();
                    productManager.find(idFind,nameFind);
                    break;
                default:
                    System.out.println("Program finished");
                    flag = false;
                    break;
            }
        }
    }
}
