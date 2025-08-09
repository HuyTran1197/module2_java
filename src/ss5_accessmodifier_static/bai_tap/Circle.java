package ss5_accessmodifier_static.bai_tap;

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

}
