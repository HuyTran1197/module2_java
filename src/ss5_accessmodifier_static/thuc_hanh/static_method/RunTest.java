package ss5_accessmodifier_static.thuc_hanh.static_method;

public class RunTest {
    public static void main(String[] args) {
        Student.change();
        Student[] student = new Student[3];
        student[0] = new Student(123,"Huy");
        student[1] = new Student(111,"Hạo");
        student[2] = new Student(125,"Minh");
        for (int i = 0; i < student.length; i++) {
            student[i].print();
        }
    }
}
