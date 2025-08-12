package ss6_inheritance.circle_cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){
    }
    public Cylinder(double radius, double height){
        super(radius);
        setHeight(height);
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        if (height<1){
            System.out.println("invalid height");
            return;
        }
        this.height = height;
    }
    public double getVolume(){
        return getArea()*getHeight();
    }
    @Override
    public String toString() {
        return "the volume of cylinder = "+getVolume();
    }
}
