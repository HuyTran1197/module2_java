package ss10_DSA_list.entity;

public class Manufacturer {
    private String id;
    private String name;
    private String country;

    public Manufacturer(String id, String name, String country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getId()+"-"+
                getName()+"-"+
                getCountry();
    }
}
