package ss10_DSA_list.entity;

public abstract class Vehicle {
    private final int id;
    private static int autoId = 1;
    private String numberOfVehicle;
    private String manufacturer;
    private int year;
    private String owner;

    public Vehicle(String numberOfVehicle, String manufacturer, int year, String owner) {
        this.id = autoId++;
        setNumberOfVehicle(numberOfVehicle);
        setManufacturer(manufacturer);
        setYear(year);
        setOwner(owner);
    }

    public int getId() {
        return id;
    }

    public String getNumberOfVehicle() {
        return numberOfVehicle;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public String getOwner() {
        return owner;
    }

    public void setNumberOfVehicle(String numberOfVehicle) {
        if (numberOfVehicle.length()<4){
            System.out.println("invalid number of vehicle");
            return;
        }
        this.numberOfVehicle = numberOfVehicle;
    }

    public void setManufacturer(String manufacturer) {
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

    @Override
    public String toString() {
        return "id: "+getId()+
                ", number of vehicle: "+getNumberOfVehicle()+
                ", manufacturer: '"+getManufacturer()+'\''+
                ", year: "+getYear()+
                ", owner: '"+getOwner()+'\'';
    }
}
