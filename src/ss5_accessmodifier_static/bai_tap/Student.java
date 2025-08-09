package ss5_accessmodifier_static.bai_tap;

public class Student {
    private static String name = "John";
    private static String classes = "C02";
    public Student(){
        Student.name = name;
        Student.classes = classes;
    }
    public static void setName(String name){
        Student.name = name;
    }
    public static void setClasses(String classes){
        Student.classes = classes;
    }
}
