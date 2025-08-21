package ss10_DSA_list.entity;

public class Motorbike extends Vehicle{
    private double capacity;

    public Motorbike() {
    }

    public Motorbike(String numberOfVehicle, String manufacturer, int year, String owner, double capacity) {
        super(numberOfVehicle, manufacturer, year, owner);
        setCapacity(capacity);
    }

    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity){
        this.capacity = capacity;
    }
    @Override
    public String toString(){
        return "Vehicle motorbike { "+super.toString()+
                ", "+getCapacity()+
                "}";
    }
}
