package ss7_abstract_interface.thuc_hanh.comparable_comparator;
import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        ComparableCircle[] comparableCircles = new ComparableCircle[3];
        comparableCircles[0] = new ComparableCircle();
        comparableCircles[1] = new ComparableCircle(5);
        comparableCircles[2] = new ComparableCircle(4, "red", false);

        System.out.println("---pre sorted---");
        for (ComparableCircle comparableCircle : comparableCircles){
            System.out.println(comparableCircle);
        }

        Arrays.sort(comparableCircles);

        System.out.println("---after sorted---");
        for (ComparableCircle comparableCircle : comparableCircles){
            System.out.println(comparableCircle);
        }
    }
}
