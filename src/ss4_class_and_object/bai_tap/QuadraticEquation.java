package ss4_class_and_object.bai_tap;
import java.util.Scanner;
import java.lang.Math;

public class QuadraticEquation {
    private double a, b, c;
    public QuadraticEquation (double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return a;
    }public double getB(){
        return b;
    }public double getC(){
        return c;
    }
    public double getDiscriminant(){
        return getB()*getB() - 4*getA()*getC();
    }
    public double getRoot1(){
        return (-getB() + Math.sqrt(getDiscriminant()))/(2*getA());
    }
    public double getRoot2(){
        return (-getB() - Math.sqrt(getDiscriminant()))/(2*getA());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("enter b");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("enter c");
        double c = Double.parseDouble(scanner.nextLine());
        if (a==0){
            System.out.println("the equation has no roots");
        } else{
            QuadraticEquation equation = new QuadraticEquation(a,b,c);
            double delta = equation.getDiscriminant();
            if (delta>0){
                System.out.println("the equation has two roots");
                System.out.print(equation.getRoot1()+" and "+equation.getRoot2());
            } else if (delta==0){
                System.out.println("the equation has one roots");
                System.out.println(equation.getRoot2());
            } else {
                System.out.println("the equation has no roots");
            }
        }
    }
}
