package ss2_loop_and_array;
import java.util.Scanner;
import java.util.Arrays;

public class FindMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int m;
        double[][] array;
        do {
            System.out.print("enter row ");
            n = Integer.parseInt(scanner.nextLine());
            System.out.print("enter col ");
            m = Integer.parseInt(scanner.nextLine());
            if (n>20 || m>20){
                System.out.println("size does not exceed 20");
            }
        }while(n>20 || m>20);
        array = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("enter element "+"["+i+"]"+"["+j+"]");
                array[i][j] = Double.parseDouble(scanner.nextLine());

            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println(" ");
        }
        double max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max<array[i][j]){
                    max = array[i][j];
                }
            }
        }
        System.out.println("max is: "+max);
    }
}
