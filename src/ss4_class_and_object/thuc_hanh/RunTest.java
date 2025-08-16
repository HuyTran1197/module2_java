package ss4_class_and_object.thuc_hanh;
import java.util.Scanner;

public class RunTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter width: ");
        double width = Double.parseDouble(scanner.nextLine());
        System.out.print("enter height: ");
        double height = Double.parseDouble(scanner.nextLine());
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("area is: "+rectangle.getArea());
        System.out.println("perimeter is: "+rectangle.getPerimeter());
        System.out.println(rectangle);
    }
}
