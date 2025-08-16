package ss4_class_and_object.thuc_hanh;

public class Rectangle {
    private double width, height;
    public Rectangle(){}
    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea(){
        return getWidth()*getHeight();
    }
    public double getPerimeter(){
        return (getArea()+getHeight())*2;
    }
    public String toString(){
        return "Rectangle {"+
                getWidth()+
                ", "+
                getHeight()+
                "}";
    }
}
