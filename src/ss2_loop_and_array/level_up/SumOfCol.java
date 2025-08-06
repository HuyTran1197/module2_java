package ss2_loop_and_array.level_up;
import java.util.Scanner;
import java.util.Arrays;

public class SumOfCol {
    static double sumCol(double[][] arr, int a){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j==a){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int n;
        int m;
        double[][] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter row of array");
            n = Integer.parseInt(scanner.nextLine());
            System.out.println("enter col of array");
            m = Integer.parseInt(scanner.nextLine());
            if (n>20 || m>20) System.out.println("size doesn't exceed 20");
        } while (n>20 || m>20);
        array = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("enter element "+"["+i+"]"+"["+j+"]");
                array[i][j] = Double.parseDouble(scanner.nextLine());
            }
        }
        System.out.println("enter col");
        int chooseCol = Integer.parseInt(scanner.nextLine());
        System.out.println(sumCol(array, chooseCol));
    }
}
// 1,2,3
// 4,5,6
