package ss2_loop_and_array;
import java.util.Scanner;

public class Prime {
    public static boolean isPrime(int n){
        if (n<2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i ==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int numbers = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int n = 2;
        while (count<numbers){
            if (isPrime(n)){
                System.out.println(n);
                count++;
            }
            n++;
        }
    }
}
