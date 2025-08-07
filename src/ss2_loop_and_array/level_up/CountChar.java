package ss2_loop_and_array.level_up;

import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        String array = "abc-_-+)*(*^%$##*)%lmn";
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a character need to count: ");
        char c = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < array.length(); i++) {
            if (c == array.charAt(i)){
                count++;
            }
        }
        System.out.println(c+" was found "+count+" times");
    }
}
