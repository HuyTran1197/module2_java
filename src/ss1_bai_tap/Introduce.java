package ss1_bai_tap;
import java.util.Scanner;
public class Introduce {
    String name;
    public Introduce(String name){
        this.name = name;
    }
    public void display(){
        System.out.println("Hello " +this.name);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        Introduce print = new Introduce(name);
        print.display();
    }
}
