package ss5_accessmodifier_static.bai_tap;
public class Circle {
    private static double radius = 1.0;
    private String color = "red";
    public Circle(){

    }
    public Circle(double radius){
        Circle.radius = radius;
    }

    protected static double getRadius() {
        return radius;
    }
    protected double getArea(){
        return (getRadius()*getRadius()) * Math.PI;
    }
}
