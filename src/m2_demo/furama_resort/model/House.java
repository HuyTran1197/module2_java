package m2_demo.furama_resort.model;

public class House extends Facility{
    private String room;
    private int floor;

    public House(String idService, String nameService, float area, int cost, int max, String rentType, String room, int floor) {
        super(idService, nameService, area, cost, max, rentType);
        this.room = room;
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public int getFloor() {
        return floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    @Override
    public String getInfoToCSV() {
        return this.getIdService()+
                ","+this.getNameService()+
                ","+this.getArea()+
                ","+this.getCost()+
                ","+this.getMax()+
                ","+this.getRentType()+
                ","+this.getRoom()+
                ","+this.getFloor();
    }
    @Override
    public String toString() {
        return "House {"+super.toString()+
                ", "+getRoom()+
                ", "+getFloor();
    }
}
