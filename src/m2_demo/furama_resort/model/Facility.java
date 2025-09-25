package m2_demo.furama_resort.model;

public abstract class Facility {
    private String idService;
    private String nameService;
    private float area;
    private int cost;
    private int max;
    private String rentType;

    public Facility(String idService, String nameService, float area, int cost, int max, String rentType) {
        this.idService = idService;
        this.nameService = nameService;
        this.area = area;
        this.cost = cost;
        this.max = max;
        this.rentType = rentType;
    }

    public String getIdService() {
        return idService;
    }

    public String getNameService() {
        return nameService;
    }

    public float getArea() {
        return area;
    }

    public int getCost() {
        return cost;
    }

    public int getMax() {
        return max;
    }

    public String getRentType() {
        return rentType;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
    public abstract String getInfoToCSV();
    @Override
    public String toString() {
        return "id service: "+getIdService()+
                ", name service: "+getNameService()+
                ", area: "+getArea()+
                ", cost: "+getCost()+
                ", max: "+getMax()+
                ", rent type: "+getRentType();
    }
}
