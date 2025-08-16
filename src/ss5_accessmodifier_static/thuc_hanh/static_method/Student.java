package ss5_accessmodifier_static.thuc_hanh.static_method;

public class Student {
    private int rollo;
    private String name;
    private static String college = "B-B-D-I-T";
    public Student(){}
    public Student(int r, String n){
        rollo = r;
        name = n;
    }
    static void change(){
        college = "CODEGYM";
    }
    void print(){
        System.out.println(rollo+" "+name+" "+college);
    }
}
