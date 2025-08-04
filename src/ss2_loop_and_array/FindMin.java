package ss2_loop_and_array;
import java.util.Scanner;
import java.util.Arrays;

public class FindMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int[] array;
        do {
            System.out.print("Enter a size: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n>20){
                System.out.println("Size does not exceed 20");
            }
        } while(n>20);
        array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("enter element "+(i+1)+": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min>array[i]){
                min = array[i];
            }
        }
        System.out.println("min is: "+min);
    }
}
