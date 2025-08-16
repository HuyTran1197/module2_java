package ss7_abstract_interface.thuc_hanh.comparable_comparator;

import ss7_abstract_interface.bai_tap.interface_resizeable.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3);
        circles[1] = new Circle();
        circles[2] = new Circle(7,"blue", false);

        System.out.println("---pre sorted---");
        for (Circle circle : circles){
            System.out.println(circle);
        }

        Comparator circleComparator = new ComparatorCircle();
        Arrays.sort(circles, circleComparator);

        System.out.println("---after sorted---");
        for (Circle circle : circles){
            System.out.println(circle);
        }
    }
}
