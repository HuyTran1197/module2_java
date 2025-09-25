package m2_demo.furama_resort.model;

public class Room extends Facility{
    private String freeService;

    public Room(String idService, String nameService, float area, int cost, int max, String rentType, String freeService) {
        super(idService, nameService, area, cost, max, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String getInfoToCSV() {
        return this.getIdService()+
                ","+this.getNameService()+
                ","+this.getArea()+
                ","+this.getCost()+
                ","+this.getMax()+
                ","+this.getRentType()+
                ","+this.getFreeService();
    }

    @Override
    public String toString() {
        return "Room {"+super.toString()+
                ", "+getFreeService();
    }
}
