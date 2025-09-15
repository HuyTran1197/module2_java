package ss10_DSA_list.entity;

public class Car extends Vehicle{
    private int seats;
    private String type;

    public Car(String numberOfVehicle, Manufacturer manufacturer, int year, String owner, int seats, String type) {
        super(numberOfVehicle, manufacturer, year, owner);
        setSeats(seats);
        setType(type);
    }
    public Car(int id,String numberOfVehicle, Manufacturer manufacturer, int year, String owner, int seats, String type) {
        super(id,numberOfVehicle, manufacturer, year, owner);
        setSeats(seats);
        setType(type);
    }


    public int getSeats() {
        return seats;
    }

    public String getType() {
        return type;
    }

    public void setSeats(int seats) {
        if (seats<2){
            System.out.println("invalid seats");
            return;
        }
        this.seats = seats;
    }

    public void setType(String type) {
        if (type==null||type.trim().isEmpty()){
            System.out.println("invalid type of car");
            return;
        }
        this.type = type;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+
                ","+this.getNumberOfVehicle()+
                ","+this.getManufacturer().getId()+
                ","+this.getYear()+","+this.getOwner()+
                ","+this.getSeats()+","+this.getType();
    }

    @Override
    public String toString(){
        return "Vehicle car { "+super.toString()+
                ", "+getSeats()+
                ", "+getType()+
                "}";
    }
}
