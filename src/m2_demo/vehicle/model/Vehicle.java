package m2_demo.vehicle.model;

public abstract class Vehicle {
    private int id;
    private String idVehicle;
    private String brand;
    private int year;
    private double price;

    public Vehicle(String idVehicle, String brand, int year, double price) {
        this.idVehicle = idVehicle;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Vehicle(int id, String idVehicle, String brand, int year, double price) {
        this(idVehicle, brand, year, price);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "id=" + id +
                ", idVehicle='" + idVehicle + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price;
    }
}
