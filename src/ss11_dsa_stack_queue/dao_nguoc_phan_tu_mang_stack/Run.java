package ss11_dsa_stack_queue.dao_nguoc_phan_tu_mang_stack;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        int n;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (n > 20);
        array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("enter element " + (i + 1) + ": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        Reverse.reverseInteger(array);

        System.out.println("\nenter a string");
        String word = scanner.nextLine();
        Reverse.reverseString(word);
    }
}
