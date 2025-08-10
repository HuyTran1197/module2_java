package ss5_accessmodifier_static.bai_tap;
import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(3);
        System.out.print("the first radius: "+Circle.getRadius()+" and area is: ");
        System.out.println(circle1.getArea());
        Scanner scanner = new Scanner(System.in);
        double radius = Double.parseDouble(scanner.nextLine());
        Circle circle2 = new Circle(radius);
        System.out.print("the second radius: "+Circle.getRadius()+" and area is: ");
        System.out.println(circle2.getArea());
    }
}
