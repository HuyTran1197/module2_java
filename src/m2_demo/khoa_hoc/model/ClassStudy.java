package m2_demo.khoa_hoc.model;

public abstract class ClassStudy {
    private int id;
    private String idCLass;
    private String nameClass;
    private String Teacher;
    private long Cost;

    public ClassStudy(String idCLass, String nameClass, String teacher, long cost) {
        this.idCLass = idCLass;
        this.nameClass = nameClass;
        Teacher = teacher;
        Cost = cost;
    }

    public ClassStudy(int id, String idCLass, String nameClass, String teacher, long cost) {
        this(idCLass, nameClass, teacher, cost);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getIdCLass() {
        return idCLass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public String getTeacher() {
        return Teacher;
    }

    public long getCost() {
        return Cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCLass(String idCLass) {
        this.idCLass = idCLass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public void setCost(long cost) {
        Cost = cost;
    }

    public abstract String getInfoCSV();

    @Override
    public String toString() {
        return "id=" + id +
                ", idCLass='" + idCLass + '\'' +
                ", nameClass='" + nameClass + '\'' +
                ", Teacher='" + Teacher + '\'' +
                ", Cost=" + Cost
                ;
    }
}
