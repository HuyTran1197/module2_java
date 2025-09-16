package ss18_string_regex.validate;
import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber="";
        do {
            System.out.print("enter your phone number: ");
            phoneNumber = scanner.nextLine();
        }while (!CheckValidate.checkNumber(phoneNumber));
        System.out.println("your phone number is true");
    }
}
