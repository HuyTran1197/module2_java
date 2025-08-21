package ss10_DSA_list.entity;

public class Car extends Vehicle{
    private int seats;
    private String type;
    public Car() {
    }

    public Car(String numberOfVehicle, String manufacturer, int year, String owner, int seats, String type) {
        super(numberOfVehicle, manufacturer, year, owner);
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
    public String toString(){
        return "Vehicle car { "+super.toString()+
                ", "+getSeats()+
                ", "+getType()+
                "}";
    }
}
