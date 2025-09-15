package ss10_DSA_list.entity;

public abstract class Vehicle {
    private int id;
    private String numberOfVehicle;
    private Manufacturer manufacturer;
    private int year;
    private String owner;

    public Vehicle(String numberOfVehicle, Manufacturer manufacturer, int year, String owner) {
        this.numberOfVehicle = numberOfVehicle;
        this.manufacturer = manufacturer;
        this.year = year;
        this.owner = owner;
    }

    public Vehicle(int id, String numberOfVehicle, Manufacturer manufacturer, int year, String owner) {
        this(numberOfVehicle,manufacturer,year,owner);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public String getNumberOfVehicle() {
        return numberOfVehicle;
    }
    public String formatNumber(){
        return "43-/"+getNumberOfVehicle()+"/";
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfVehicle(String numberOfVehicle) {
        if (numberOfVehicle.length()<4){
            System.out.println("invalid number of vehicle");
            return;
        }
        this.numberOfVehicle = numberOfVehicle;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null) {
            System.out.println("invalid manufacturer");
            return;
        }
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        if (year < 1700) {
            System.out.println("invalid year of manufacturer");
            return;
        }
        this.year = year;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.trim().isEmpty()) {
            System.out.println("invalid own of vehicle");
            return;
        }
        this.owner = owner;
    }
    public abstract String getInfoToCSV();
    @Override
    public String toString() {
        return "id: "+getId()+
                ", number of vehicle: "+formatNumber()+
                ", manufacturer: '"+getManufacturer()+'\''+
                ", year: "+getYear()+
                ", owner: '"+getOwner()+'\'';
    }
}
