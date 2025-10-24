package m2_demo.practice_java.practice2.entity;

public class Product {
    private String id;
    private String name;
    private int price;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfoCSV(){
        return this.getId()+
                ","+this.getName()+
                ","+this.getPrice();
    }

    public String toStringList(){
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\''+
                "}";
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
