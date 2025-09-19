package m2_demo.furama_resort.model;

public class Employee extends Person{
    private String level;
    private String position;
    private int salary;

    public Employee(String id, String name, String birthday, String sexual, String idPerson, String phone, String email, String level, String position, int salary) {
        super(id, name, birthday, sexual, idPerson, phone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
                ","+this.getLevel()+
                ","+this.getPosition()+
                ","+this.getSalary();
    }

    @Override
    public String toString() {
        return "Employee {"+super.toString()+
                ", "+getLevel()+
                ", "+getPosition()+
                ", "+getSalary()+
                "}";
    }
}
