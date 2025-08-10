package ss5_accessmodifier_static.bai_tap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String classes = scanner.nextLine();
        Student student = new Student();
        student.setName(name);
        student.setClasses(classes);
        }
}
