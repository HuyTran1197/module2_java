package m2_demo.exam_m2.model;

public class PhoneList {
    private String phone;
    private String group;
    private String name;
    private String sexual;
    private String birthday;
    private String email;
    private String address;

    public PhoneList(){

    }

    public PhoneList(String phone, String group, String name, String sexual, String birthday){
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.sexual = sexual;
        this.birthday = birthday;
    }

    public PhoneList(String phone, String group, String name, String sexual, String birthday, String email, String address) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.sexual = sexual;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getSexual() {
        return sexual;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSexual(String sexual) {
        this.sexual = sexual;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfoCSV(){
        return this.getPhone()+
                ","+this.getGroup()+
                ","+this.getName()+
                ","+this.getSexual()+
                ","+this.getBirthday()+
                ","+this.getEmail()+
                ","+this.getAddress();
    }

    public String toStringList() {
        return "PhoneList{" +
                "phone='" + phone + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", sexual='" + sexual + '\'' +
                ", birthday='" + birthday + '\''+
                '}';
    }

    @Override
    public String toString() {
        return "PhoneList{" +
                "phone='" + phone + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", sexual='" + sexual + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
