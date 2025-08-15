package ss7_abstract_interface.bai_tap.interface_colorable;

import ss7_abstract_interface.bai_tap.interface_resizeable.Circle;
import ss7_abstract_interface.bai_tap.interface_resizeable.Rectangle;
import ss7_abstract_interface.bai_tap.interface_resizeable.Shape;
import ss7_abstract_interface.bai_tap.interface_resizeable.Square;

public class RunColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Square(5);
        shapes[1] = new Circle(5);
        shapes[2] = new Rectangle(5,8);
        shapes[3] = new Square();
        shapes[4] = new Rectangle(12,7);

        System.out.println("---Colorable---");
        for (int i = 0; i < shapes.length; i++) {
            System.out.print("area of element "+i+": ");
            System.out.println(shapes[i].getArea2());
            if (shapes[i] instanceof Square){
                Colorable colorable = (Square) shapes[i];
                System.out.println("element "+i+" can call howToColor() : "+colorable.howToColor());
            }
        }
    }
}
