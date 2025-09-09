package ss15_exception.bai_tap;

import java.util.Scanner;

public class IllegalTriangleException{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("enter b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.print("enter c: ");
        int c = Integer.parseInt(scanner.nextLine());
        triangleExample(a,b,c);
    }

    private static void triangleExample(int a, int b, int c){
        try {
            if (a+b>c && a+c>b && b+c>a){
                System.out.println("a,b,c is a triangle");
            } else if (a>0 && b>0 && c>0) {
                System.out.println("a,b,c is a triangle");
            }
        }catch (Exception e){
            System.out.println("exception is: "+e.getMessage());
        }
    }
}
