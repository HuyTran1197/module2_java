package ss10_DSA_list.entity;

public class Truck extends Vehicle{
    private double load;

    public Truck() {
    }

    public Truck(String numberOfVehicle, String manufacturer, int year, String owner, double load) {
        super(numberOfVehicle, manufacturer, year, owner);
        setLoad(load);
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
    @Override
    public String toString(){
        return "Vehicle truck { "+super.toString()+
                ", "+getLoad()+
                "}";
    }
}
