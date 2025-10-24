package m2_demo.practice_java.practice2.service;

import m2_demo.exam_m2.model.PhoneList;
import m2_demo.practice_java.practice2.entity.Product;
import m2_demo.practice_java.practice2.repo.IProductRepo;
import m2_demo.practice_java.practice2.repo.ProductRepo;

import java.util.LinkedList;
import java.util.List;

public class ProductService implements IProductService{
    private static IProductRepo productRepo = new ProductRepo();
    private static LinkedList<Product> productLinkedList = new LinkedList<>();

    static{
        productLinkedList.add(new Product("NPID-0036","Samsung Note5"));
        productLinkedList.add(new Product("NPID-0037","Iphone15"));
        productLinkedList.add(new Product("NPID-0025","Iphone11 ProMax"));
    }

    public void getList(){
        for (Product p : productLinkedList){
            System.out.println(p.toStringList());
        }
    }

    @Override
    public List<Product> getAll(){
        return productRepo.getAll();
    }

    @Override
    public boolean add(Product product){
        for (Product p : productRepo.getAll()){
            if (p.getId().equals(product.getId())){
                System.out.println("id is already exists");
                return false;
            }
        }
        return productRepo.add(product);
    }

    @Override
    public boolean delete(String id){
        return productRepo.delete(id);
    }

    @Override
    public List<Product> findByKeyword(String keyword){
        return productRepo.findByKeyword(keyword);
    }

    public Product findToShow(String id){
        List<Product> phoneListList = getAll();
        for (Product p : phoneListList){
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
