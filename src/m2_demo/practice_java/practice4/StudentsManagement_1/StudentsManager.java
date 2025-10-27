package m2_demo.practice_java.practice4.StudentsManagement_1;

import java.util.Arrays;
import java.util.Scanner;

public class StudentsManager {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        String[] name;
        double[] score;
        do {
            System.out.print("enter quantity students: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n>=10) System.out.println("class size cannot exceed 10 students");
        }while (n>=10);

        name = new String[n];
        score = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("enter students name "+(i+1)+": ");
            name[i] = scanner.nextLine();
            do {
                System.out.print("enter students score "+(i+1)+": ");
                score[i] = Double.parseDouble(scanner.nextLine());
                if (score[i]<0 || score[i]>10) System.out.println("score must be between 0 and 10");
            }while (score[i]<0 || score[i]>10);
        }
        System.out.println(Arrays.toString(name));
        System.out.println(Arrays.toString(score));
        findGoodStudents(name,score);
        findBestStudent(name,score);
        System.out.println(findAverageClass(score));
    }

    private static void findGoodStudents(String[] name, double[] score){
        System.out.println("Students has score above 8.0:");
        for (int i = 0; i < score.length; i++) {
            if (score[i]>=8){
                System.out.println(name[i]);
            }
        }
    }
    private static void findBestStudent(String[] name, double[] score){
        double max = score[0];
        int index = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i]>max){
                max = score[i];
                index = i;
            }
        }
        System.out.println("Best student is: "+name[index]);
    }
    private static double findAverageClass(double[] score){
        double sum = 0;
        for (double s : score){
            sum += s;
        }
        System.out.print("Average class = ");
        return sum/ score.length;
    }
}