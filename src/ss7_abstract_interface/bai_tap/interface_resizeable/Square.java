package ss7_abstract_interface.bai_tap.interface_resizeable;

import ss7_abstract_interface.bai_tap.interface_colorable.Colorable;

public class Square extends Shape implements Resizeable, Colorable {
    private double side;
    public Square(){}
    public Square(double side){
        this.side = side;
    }
    public double getSide(){
        return side;
    }
    public double getArea(){
        return getSide()*getSide();
    }
    public void setSide(double side){
        this.side = side;
    }
    @Override
    public void reSize(double percent){
        side += (getSide()*percent)/100;
    }
    @Override
    public double getArea2(){
        return getArea();
    }
    @Override
    public String howToColor(){
        return "Color all four sides";
    }
    @Override
    public String toString(){
        return "A Square with side= "+
                getSide()+
                ", which is a subclass of "+
                super.toString();
    }
}
