package m2_demo.vehicle.model;

public class Motorbike extends Vehicle{
    private int engineCapacity;

    public Motorbike(String idVehicle, String brand, int year, double price, int engineCapacity) {
        super(idVehicle, brand, year, price);
        this.engineCapacity = engineCapacity;
    }

    public Motorbike(int id, String idVehicle, String brand, int year, double price, int engineCapacity) {
        super(id, idVehicle, brand, year, price);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getInfo() {
        return this.getId()+
                ","+this.getIdVehicle()+
                ","+this.getBrand()+
                ","+this.getYear()+
                ","+this.getPrice()+
                ","+this.getEngineCapacity();
    }

    @Override
    public String toString() {
        return "Motorbike {"+super.toString()+
                ", "+getEngineCapacity();
    }
}
