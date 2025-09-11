package ss8_model_view_controller.entity;

public abstract class Person {
    private int id;
    private String name;
    private String email;
    private String address;

    public Person() {
    }

    public Person(int id, String name, String email, String address) {
        setId(id);
        setName(name);
        setEmail(email);
        setAddress(address);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        if (id<1){
            System.out.println("invalid id");
            return;
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            System.out.println("invalid name value");
            return;
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email==null || email.trim().isEmpty()){
            System.out.println("invalid email value");
            return;
        }
        this.email = email;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()){
            System.out.println("invalid address value");
            return;
        }
        this.address = address;
    }
    public abstract String getInfoToCSV();
    @Override
    public String toString(){
        return "id: "+getId()+
                ", name: '"+getName()+'\''+
                ", email: "+getEmail()+
                ", address: "+getAddress();
    }
}
