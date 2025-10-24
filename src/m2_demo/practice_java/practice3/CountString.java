package m2_demo.practice_java.practice3;

import java.util.Scanner;

public class CountString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string to count: ");
        String charString = scanner.nextLine();
        int letters = 0;
        int numbers = 0;
        int spaces = 0;
        int special = 0;
        for (Character c : charString.toCharArray()){
            if (c>='a' && c<='z' || c>='A' && c<='Z'){
                letters++;
            } else if (c >= '0' && c <= '9') {
                numbers++;
            } else if (c == ' ') {
                spaces++;
            }else {
                special++;
            }
        }
        System.out.println(letters+","+numbers+","+spaces+","+special);
    }
}
