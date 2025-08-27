package ss12_java_collection_framework;

public class Product {
    private final int id;
    private String name;
    private int price;
    private static int autoId = 1;

    public Product(String name, int price) {
        this.id = autoId++;
        setName(name);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            System.out.println("invalid name");
            return;
        }
        this.name = name;
    }

    public void setPrice(int price) {
        if (price<1){
            System.out.println("invalid price");
            return;
        }
        this.price = price;
    }
    @Override
    public String toString(){
        return "Product {"+
                "id: "+getId()+
                ", name: '"+getName()+'\''+
                ", price: "+getPrice()+
                "}";
    }
}
