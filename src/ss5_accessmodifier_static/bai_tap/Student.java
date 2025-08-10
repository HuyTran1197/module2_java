package ss5_accessmodifier_static.bai_tap;

public class Student {
    private static String name = "John";
    private static String classes = "C02";
    public Student(){

    }
    protected void setName(String name){
        Student.name = name;
        System.out.print("My name is "+Student.name);
    }
    protected void setClasses(String classes){
        Student.classes = classes;
        System.out.print(" and I'm learning class "+Student.classes+" at CodeGym Da Nang");
    }
}
