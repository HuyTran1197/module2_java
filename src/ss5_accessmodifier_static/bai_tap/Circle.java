package ss5_accessmodifier_static.bai_tap;

import java.util.Scanner;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;
    }

    private double getRadius() {
        return radius;
    }
    protected double getArea(){
        return (getRadius()*getRadius()) * Math.PI;
    }
    static class TestCircle{
        public static void main(String[] args) {
            Circle circle1 = new Circle(3);
            System.out.println(circle1.getArea());
            Scanner scanner = new Scanner(System.in);
            double radius = Double.parseDouble(scanner.nextLine());
            Circle circle2 = new Circle(radius);
            System.out.println(circle2.getArea());
        }
    }

}
