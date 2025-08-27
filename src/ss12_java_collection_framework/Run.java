package ss12_java_collection_framework;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("-----Car Product Manager Program-----");
            System.out.println("Function: "+
                    "\n 1. List"+
                    "\n 2. Add"+
                    "\n 3. Delete"+
                    "\n 4. Update"+
                    "\n 5. Find"+
                    "\n 6. Out"
            );
            System.out.println("choose a function");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("List Product");
                    productManager.listProduct();
                    break;
                case 2:
                    System.out.println("Add");
                    System.out.print("enter name: ");
                    String nameAdd = scanner.nextLine();
                    System.out.print("enter price: ");
                    int priceAdd = Integer.parseInt(scanner.nextLine());
                    productManager.addProduct(nameAdd,priceAdd);
                    break;
                case 3:
                    System.out.println("Delete");
                    System.out.print("enter id need to delete: ");
                    int idDel = Integer.parseInt(scanner.nextLine());
                    productManager.deleteProduct(idDel);
                    break;
                case 4:
                    System.out.println("Update");
                    System.out.println("enter id need to update: ");
                    int idCheck = Integer.parseInt(scanner.nextLine());
                    System.out.println("enter name need to update");
                    String nameUpdate = scanner.nextLine();
                    System.out.println("enter price need to update");
                    int priceUpdate = Integer.parseInt(scanner.nextLine());
                    productManager.update(idCheck,nameUpdate,priceUpdate);
                    break;
                case 5:
                    System.out.println("Find");
                    System.out.println("enter name of product need to find");
                    String nameFind = scanner.nextLine();
                    productManager.find(nameFind);
                    break;
                default:
                    System.out.println("Finished program");
                    flag = false;
                    break;
            }
        }
    }
}
