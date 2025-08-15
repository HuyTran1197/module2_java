package ss7_abstract_interface.bai_tap.interface_resizeable;

public class RunTest {
    public static void main(String[] args) {
        Shape[] circles = new Circle[2];
        circles[0] = new Circle(2);
        circles[1] = new Circle(5);

        Shape[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(2,3);
        rectangles[1] = new Rectangle(5,7);
        rectangles[2] = new Rectangle(5,10);

        Shape[] squares = new Square[4];
        squares[0] = new Square(5);
        squares[1] = new Square(7);
        squares[2] = new Square(15);
        squares[3] = new Square(18);

        System.out.println("---before increase---");
        for (int i = 0; i < circles.length; i++) {
            System.out.print("circle area of element "+i+": ");
            System.out.println(((Circle) circles[i]).getArea());
        }
        for (int i = 0; i < rectangles.length; i++) {
            System.out.print("rectangle area of element "+i+": ");
            System.out.println(((Rectangle)rectangles[i]).getArea());
        }
        for (int i = 0; i < squares.length; i++) {
            System.out.print("square area of element "+i+": ");
            System.out.println(((Square)squares[i]).getArea());
        }

        System.out.println("---after increase---");
        for (int i = 0; i < circles.length; i++) {
            circles[i].reSize((Math.random()*99)+1);
            System.out.print("circle area of element "+i+": ");
            System.out.println(((Circle) circles[i]).getArea());
        }
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].reSize((Math.random()*99)+1);
            System.out.print("rectangle area of element "+i+": ");
            System.out.println(((Rectangle)rectangles[i]).getArea());
        }
        for (int i = 0; i < squares.length; i++) {
            squares[i].reSize((Math.random()*99)+1);
            System.out.print("square area of element "+i+": ");
            System.out.println(((Square)squares[i]).getArea());
        }
    }
}
