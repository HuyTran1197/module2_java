package ss7_abstract_interface.thuc_hanh.comparable_comparator;

import ss7_abstract_interface.bai_tap.interface_resizeable.Circle;

import java.util.Comparator;

public class ComparatorCircle extends Circle implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2){
        if (c1.getRadius()>c2.getRadius()) return 1;
        else if (c1.getRadius()<c2.getRadius()) return -1;
        else return 0;
    }
}
