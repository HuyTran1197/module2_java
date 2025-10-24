package m2_demo.practice_java.practice1;

import java.util.Scanner;

public class Average {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        double[] score;
        do {
            System.out.print("enter a size: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n>20) System.out.println("size doesn't exceed 20");
        }while (n>20);

        score = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("enter score of subjects "+(i+1)+": ");
            score[i] = Double.parseDouble(scanner.nextLine());
            sum += score[i];
        }
        double result = sum/n;
        System.out.println("Average score of student is= "+result);
        if (result>=8.5){
            System.out.println("Good student");
        } else if (result >= 6.5) {
            System.out.println("Quite student");
        }else {
            System.out.println("Average student");
        }
    }
}
