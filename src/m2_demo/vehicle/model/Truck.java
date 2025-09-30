package m2_demo.vehicle.model;

public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck(String idVehicle, String brand, int year, double price, double loadCapacity) {
        super(idVehicle, brand, year, price);
        this.loadCapacity = loadCapacity;
    }

    public Truck(int id, String idVehicle, String brand, int year, double price, double loadCapacity) {
        super(id, idVehicle, brand, year, price);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getInfo() {
        return this.getId()+
                ","+this.getIdVehicle()+
                ","+this.getBrand()+
                ","+this.getYear()+
                ","+this.getPrice()+
                ","+this.getLoadCapacity();
    }

    @Override
    public String toString() {
        return "Truck {"+super.toString()+
                ", "+getLoadCapacity();
    }
}
