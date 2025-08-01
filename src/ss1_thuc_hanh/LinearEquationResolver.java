package ss1_thuc_hanh;

import org.w3c.dom.ls.LSOutput;

public class LinearEquationResolver {
    double a;
    double b;
    double c;
    public LinearEquationResolver (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getResolver() {
        if (this.a == 0){
            if (this.b == this.c) {
                System.out.println("The solution is all x!");
            } else {
                System.out.println("No solution");
            }
        }
        return (this.c - this.b) / this.a;
    }
    public void print(){
        System.out.println(getResolver());
    }
}