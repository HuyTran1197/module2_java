package ss2_loop_and_array.level_up;
import java.util.Scanner;

public class Matrix {
    static int sumMatrix(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i==j){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int m;
        int[][] array;
        do {
            System.out.println("enter row of array");
            n = Integer.parseInt(scanner.nextLine());
            System.out.println("enter col of array");
            m = Integer.parseInt(scanner.nextLine());
            if (n>20 || m>20) System.out.println("size doesn't exceed 20");
        } while(n>20 || m>20);
        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("enter element "+"["+i+"]"+"["+j+"]");
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println(sumMatrix(array));
    }
}
// 1,2,3
// 3,4,2
// 4,5,6
// i=0;j=0
// i=1;j=1;

