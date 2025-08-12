package ss6_inheritance.circle_cylinder;

public class Circle {
    private double radius;
    private final String color = "red";

    public Circle() {
    }
    public Circle(double radius){
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius<1){
            System.out.println("invalid radius");
            return;
        }
        this.radius = radius;
    }

    protected double getArea(){
        return (getRadius()*getRadius()) * Math.PI;
    }
    @Override
    public String toString() {
        return "the area of circle = "+getArea();
    }
}
