package m2_demo.furama_resort.model;

public abstract class Person {
    private String id;
    private String name;
    private String birthday;
    private String sexual;
    private String idPerson;
    private String phone;
    private String email;

    public Person(String id, String name, String birthday, String sexual, String idPerson, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sexual = sexual;
        this.idPerson = idPerson;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSexual() {
        return sexual;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSexual(String sexual) {
        this.sexual = sexual;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public abstract String getInfoToCSV();
    @Override
    public String toString() {
        return "id: "+getId()+
                ", name: "+getName()+
                ", birthday: "+getBirthday()+
                ", sexual: "+getSexual()+
                ", idPerson: "+ getIdPerson()+
                ", Telephone: "+getPhone()+
                ", email: "+getEmail();
    }
}
