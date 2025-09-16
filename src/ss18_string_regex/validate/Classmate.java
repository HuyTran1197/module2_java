package ss18_string_regex.validate;
import java.util.Scanner;

public class Classmate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name ="";
        do {
            System.out.print("enter your classmate name: ");
            name = scanner.nextLine();
        }while (!CheckValidate.checkNameClass(name));
        System.out.println("classmate name is true");
    }
}
