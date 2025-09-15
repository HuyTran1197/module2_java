package ss10_DSA_list.entity;

public class Truck extends Vehicle{
    private double load;


    public Truck(String numberOfVehicle, Manufacturer manufacturer, int year, String owner, double load) {
        super(numberOfVehicle, manufacturer, year, owner);
        setLoad(load);
    }

    public Truck(int id, String numberOfVehicle, Manufacturer manufacturer, int year, String owner, double load) {
        super(id, numberOfVehicle, manufacturer, year, owner);
        setLoad(load);
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        if (load < 500){
            System.out.println("invalid load");
            return;
        }
        this.load = load;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+
                ","+this.getNumberOfVehicle()+
                ","+this.getManufacturer().getId()+
                ","+this.getYear()+
                ","+this.getOwner()+
                ","+this.getLoad();
    }

    @Override
    public String toString(){
        return "Vehicle truck { "+super.toString()+
                ", "+getLoad()+
                "}";
    }
}
