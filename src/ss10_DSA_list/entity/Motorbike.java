package ss10_DSA_list.entity;

public class Motorbike extends Vehicle{
    private String capacity;


    public Motorbike(String numberOfVehicle, Manufacturer manufacturer, int year, String owner,String capacity) {
        super(numberOfVehicle, manufacturer, year, owner);
        setCapacity(capacity);
    }

    public Motorbike(int id, String numberOfVehicle, Manufacturer manufacturer, int year, String owner, String capacity) {
        super(id, numberOfVehicle, manufacturer, year, owner);
        setCapacity(capacity);
    }

    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity){
        this.capacity = capacity;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+
                ","+this.getNumberOfVehicle()+
                ","+this.getManufacturer().getId()+
                ","+this.getYear()+
                ","+this.getOwner()+
                ","+this.getCapacity();
    }

    @Override
    public String toString(){
        return "Vehicle motorbike { "+super.toString()+
                ", "+getCapacity()+
                "}";
    }
}
