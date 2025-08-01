package ss1_thuc_hanh;

public class Rectangle {
    float width;
    float height;
    public Rectangle(float width, float height){
        this.width = width;
        this.height = height;
    }
    public float getArea(){
        return this.width * this.height;
    }
    public void print(){
        System.out.println("Area is: "+getArea());
    }
}
