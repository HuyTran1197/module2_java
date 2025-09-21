package m2_demo.furama_resort.model;

public class Customer extends Person{
    private String typeCus;
    private String address;

    public Customer(String id, String name, String birthday, String sexual, String idPerson, String phone, String email, String typeCus, String address) {
        super(id, name, birthday, sexual, idPerson, phone, email);
        this.typeCus = typeCus;
        this.address = address;
    }

    public String getTypeCus() {
        return typeCus;
    }

    public String getAddress() {
        return address;
    }

    public void setTypeCus(String typeCus) {
        this.typeCus = typeCus;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer {"+super.toString()+
                ", "+getTypeCus()+
                ", "+getAddress();
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+
                ","+this.getName()+
                ","+this.getBirthday()+
                ","+this.getSexual()+
                ","+this.getIdPerson()+
                ","+this.getPhone()+
                ","+this.getEmail()+
                ","+this.getTypeCus()+
                ","+this.getAddress();
    }
}
