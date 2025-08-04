package ss2_loop_and_array;
import java.util.Scanner;
import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int n;
        int[] array1;
        int[] array2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("enter a size: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n>20){
                System.out.println("size does not exceed 20");
            }
        } while(n>20);
        array1 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("enter element "+(i+1)+" of array1"+": ");
            array1[i]= Integer.parseInt(scanner.nextLine());
        }
        array2 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("enter element "+(i+1)+" of array2"+": ");
            array2[i]= Integer.parseInt(scanner.nextLine());
        }
        System.out.print("array1 = ");
        System.out.println(Arrays.toString(array1));
        System.out.print("array2 = ");
        System.out.println(Arrays.toString(array2));
        int[] array3 = new int[array1.length+array2.length];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[i+array2.length] = array2[i];
        }
        System.out.print("array3 = ");
        System.out.println(Arrays.toString(array3));
    }
}
