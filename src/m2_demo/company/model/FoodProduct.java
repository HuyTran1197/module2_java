package m2_demo.company.model;

public class FoodProduct extends Product{
    private String expiryDate;
    private String origin;

    public FoodProduct(String name, double price, String expiryDate, String origin) {
        super(name, price);
        this.expiryDate = expiryDate;
        this.origin = origin;
    }

    public FoodProduct(int id, String name, double price, String expiryDate, String origin) {
        super(id, name, price);
        this.expiryDate = expiryDate;
        this.origin = origin;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String getInfo() {
        return this.getId()+
                ","+this.getName()+
                ","+this.getPrice()+
                ","+this.getExpiryDate()+
                ","+this.getOrigin();
    }

    @Override
    public String toString() {
        return "Food product {"+super.toString()+
                ", "+getExpiryDate()+
                ", "+getOrigin()+
                "}";
    }
}
