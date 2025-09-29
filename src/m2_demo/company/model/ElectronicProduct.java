package m2_demo.company.model;

public class ElectronicProduct extends Product{
    private int warrantyMonths;
    private String brand;

    public ElectronicProduct(String name, double price, int warrantyMonths, String brand) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }

    public ElectronicProduct(int id, String name, double price, int warrantyMonths, String brand) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getInfo() {
        return this.getId()+
                ","+this.getName()+
                ","+this.getPrice()+
                ","+this.getWarrantyMonths()+
                ","+this.getBrand();
    }

    @Override
    public String toString() {
        return "Electronic {"+super.toString()+
                ", "+getWarrantyMonths()+
                ", "+getBrand()+
                "}";
    }
}
