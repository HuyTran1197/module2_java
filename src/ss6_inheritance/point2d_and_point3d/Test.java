package ss6_inheritance.point2d_and_point3d;
import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter x: ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.print("enter y: ");
        float y = Float.parseFloat(scanner.nextLine());
        System.out.print("enter z: ");
        float z = Float.parseFloat(scanner.nextLine());
        Point2D point2D = new Point3D(x,y,z);
        System.out.println(point2D);

        System.out.println(Arrays.toString(point2D.getXY()));
        System.out.println(Arrays.toString(((Point3D) point2D).getXYZ()));
    }
}
