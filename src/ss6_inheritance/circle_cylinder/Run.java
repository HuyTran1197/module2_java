package ss6_inheritance.circle_cylinder;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter radius: ");
        double radius = Double.parseDouble(scanner.nextLine());
        Circle circle = new Circle(radius);
        System.out.println(circle);
        System.out.print("enter height: ");
        double height = Double.parseDouble(scanner.nextLine());
        Cylinder cylinder = new Cylinder(radius,height);
        System.out.println(cylinder);
    }
}
