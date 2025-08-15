package ss7_abstract_interface.bai_tap.interface_resizeable;

public class Square extends Shape implements Resizeable{
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
    public String toString(){
        return "A Square with side= "+
                getSide()+
                ", which is a subclass of "+
                super.toString();
    }
}
