package ss2_loop_and_array_method.level_up;
import java.util.Scanner;
import java.util.Arrays;

public class Student {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter size");
            size = Integer.parseInt(scanner.nextLine());
            if (size>30) System.out.println("size doesn't exceed 30");
        } while(size>30);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("enter element "+(i+1)+": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(array));
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]<=10 && array[i]>5){
                count++;
            }
        }
        System.out.println("The number of student pass the exam is: "+count);
    }
}
