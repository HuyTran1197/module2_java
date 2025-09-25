package m2_demo.furama_resort.model;

public class Villa extends Facility{
    private String room;
    private float areaPool;
    private int floor;

    public Villa(String idService, String nameService, float area, int cost, int max, String rentType, String room, float areaPool, int floor) {
        super(idService, nameService, area, cost, max, rentType);
        this.room = room;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public float getAreaPool() {
        return areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setAreaPool(float areaPool) {
        this.areaPool = areaPool;
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
                ","+this.getAreaPool()+
                ","+this.getFloor();
    }

    @Override
    public String toString() {
        return "Villa {"+super.toString()+
                ", "+getRoom()+
                ", "+getAreaPool()+
                ", "+getFloor();
    }
}
