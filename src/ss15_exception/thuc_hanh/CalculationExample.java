package ss15_exception.thuc_hanh;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("enter y: ");
        int y = Integer.parseInt(scanner.nextLine());
        calc(x,y);
    }

    private static void calc(int x, int y){
        try {
            int a = x+y;
            int b = x-y;
            int c = x*y;
            int d = x/y;
            System.out.println("sum is: "+a);
            System.out.println("subtract is: "+b);
            System.out.println("multiple is: "+c);
            System.out.println("divide is: "+d);
        } catch (Exception e) {
            System.out.println("exception is: "+e.getMessage());
        }
    }
}
