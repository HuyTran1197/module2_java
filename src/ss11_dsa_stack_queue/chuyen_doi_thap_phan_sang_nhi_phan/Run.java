package ss11_dsa_stack_queue.chuyen_doi_thap_phan_sang_nhi_phan;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number: ");
        int n = Integer.parseInt(scanner.nextLine());
        Exchange.exchangeNumber(n);
    }
}
