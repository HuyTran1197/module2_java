package ss10_DSA_list.entity;

public class Motorbike extends Vehicle{
    private String capacity;


    public Motorbike(String numberOfVehicle, String manufacturer, int year, String owner, String capacity) {
        super(numberOfVehicle, manufacturer, year, owner);
        setCapacity(capacity);
    }

    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity){
        this.capacity = capacity;
    }
    @Override
    public String toString(){
        return "Vehicle motorbike { "+super.toString()+
                ", "+getCapacity()+
                "}";
    }
}
