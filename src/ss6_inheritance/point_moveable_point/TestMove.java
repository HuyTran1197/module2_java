package ss6_inheritance.point_moveable_point;
import ss6_inheritance.point2d_and_point3d.Point2D;

import java.util.Scanner;
import java.util.Arrays;

public class TestMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter x: ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.print("enter y: ");
        float y = Float.parseFloat(scanner.nextLine());
        System.out.print("enter x speed: ");
        float xS = Float.parseFloat(scanner.nextLine());
        System.out.print("enter y speed: ");
        float yS = Float.parseFloat(scanner.nextLine());

        Point2D moveTest = new MoveAblePoint(x,y,xS,yS);
        System.out.println(moveTest);
        System.out.println(((MoveAblePoint) moveTest).move());
        System.out.println(Arrays.toString(((MoveAblePoint) moveTest).getSpeed()));
    }
}
