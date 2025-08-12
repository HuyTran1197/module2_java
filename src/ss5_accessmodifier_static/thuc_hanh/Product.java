package ss5_accessmodifier_static.thuc_hanh;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(){

    }
    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setId(int id){
        if (id<1){
            System.out.println("invalid ID");
            return;
        }
        this.id = id;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            System.out.println("invalid name");
            return;
        }
        this.name = name;
    }
    public void setPrice(double price) {
        if (price<1){
            System.out.println("invalid price");
            return;
        }
        this.price = price;
    }
    @Override
    public String toString(){
        return "Product {"+
                "id= "+getId()+
                ", name is: '"+getName()+'\''+
                ", price = "+getPrice()+
                "}";
    }
}
