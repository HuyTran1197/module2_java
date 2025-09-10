package ss15_exception.bai_tap;

import java.util.Scanner;

public class IllegalTriangleException{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("enter a: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("enter b: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.print("enter c: ");
            int c = Integer.parseInt(scanner.nextLine());
            triangleExample(a,b,c);
        } catch (Exception e) {
            System.out.println("exception is: "+e.getMessage());
        }

    }

    private static void triangleExample(int a, int b, int c) throws Exception{
        if (a<=0 || b<=0 || c<=0){
            throw new Exception("length of triangle must be bigger 0");
        } if (a+b<=c || a+c<=b || c+b<=a){
            throw new Exception("not is a triangle");
        }
        System.out.println("a,b,c is a triangle");
    }
}
