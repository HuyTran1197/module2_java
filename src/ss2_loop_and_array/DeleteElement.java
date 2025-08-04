package ss2_loop_and_array;
import java.util.Scanner;
import java.util.Arrays;

public class DeleteElement {
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
        System.out.println("array before delete");
        System.out.println(Arrays.toString(array));
        System.out.print("enter the element need to delete: ");
        int findX = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findX) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }
        int[] newArr = new int[array.length-1];
        for (int i = 0; i < array.length-1; i++) {
            newArr[i] = array[i];
        }
        System.out.println("array after delete");
        System.out.println(Arrays.toString(newArr));
    }
}
