package ss2_loop_and_array;

import java.util.Scanner;

public class PrintMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Menu");
            System.out.println("1. Print the Rectangle");
            System.out.println("2. Print the square Triangle");
            System.out.println("3. Print isosceles Triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Show the rectangle");
                    int[][] array = new int[3][7];
                    for (int i = 0; i < array.length; i++) {
                        for (int j = 0; j < array[i].length; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    System.out.println("Show square triangle");
                    int[][] array2 = new int[5][5];
                    for (int i = 0; i < array2.length; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    for (int i = array2.length - 1; i >= 0; i--) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Show isosceles triangle");
                    int[][] array3 = new int[5][5];
                    for (int i = 0; i < array3.length; i++) {
                        for (int j = 0; j < array3[i].length*2; j++) {
                            if (j>=array3[i].length-i && j<=array3[i].length+i){
                                System.out.print("*");
                            } else{
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
// * * * * *
// * * * * *
// * * * * *
// * * * * *
// * * * * *
