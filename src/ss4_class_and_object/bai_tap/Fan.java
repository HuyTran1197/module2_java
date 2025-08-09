package ss4_class_and_object.bai_tap;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }
    public Fan(int speed, boolean on, double radius, String color){
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean isOn(){
        return on;
    }
    public String getColor(){
        return color;
    }

    public double getRadius() {
        return radius;
    }
    public void setSpeed(int speed){
        if (speed>FAST || speed<SLOW){
            System.out.println("cannot start machine with speed: "+speed);
            return;
        }
        this.speed = speed;
    }
    public void setOn(boolean on) {
        this.on = on;
    }
    public void setRadius(double radius) {
        if (radius<1){
            System.out.println(radius+" is not the radius");
            return;
        }
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        if (isOn()){
            return "fan is on: "+"speed is: "+getSpeed()+", radius is: "+getRadius()+", color is: "+getColor();
        }
        return "fan is off: "+"radius is: "+getRadius()+", color is: "+getColor();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fan fan1 = new Fan(3,true,10,"yellow");
        Fan fan2 = new Fan(2,false,8,"red");
        Fan fan3 = new Fan();
        System.out.println(fan1);
        System.out.println(fan2);
        System.out.println("enter speed");
        int inputSpeed = Integer.parseInt(scanner.nextLine());
        System.out.println("please enter true or false to on or off machine");
        boolean inputOn = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("enter radius machine");
        double inputRadius = Double.parseDouble(scanner.nextLine());
        System.out.println("enter color machine");
        String inputColor = scanner.nextLine();
        fan3.setSpeed(inputSpeed);
        fan3.setOn(inputOn);
        fan3.setRadius(inputRadius);
        fan3.setColor(inputColor);
        System.out.println(fan3);
    }
}
