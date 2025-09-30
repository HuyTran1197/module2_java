package m2_demo.vehicle.model;

public class Car extends Vehicle{
    private int seats;
    private String fuelType;

    public Car(String idVehicle, String brand, int year, double price, int seats, String fuelType) {
        super(idVehicle, brand, year, price);
        this.seats = seats;
        this.fuelType = fuelType;
    }

    public Car(int id, String idVehicle, String brand, int year, double price, int seats, String fuelType) {
        super(id, idVehicle, brand, year, price);
        this.seats = seats;
        this.fuelType = fuelType;
    }

    public int getSeats() {
        return seats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String getInfo() {
        return this.getId()+
                ","+this.getIdVehicle()+
                ","+this.getBrand()+
                ","+this.getYear()+
                ","+this.getPrice()+
                ","+this.getSeats()+
                ","+this.getFuelType();
    }

    @Override
    public String toString() {
        return "Car {"+super.toString()+
                ", "+getSeats()+
                ", "+getFuelType()+
                "}";
    }
}
