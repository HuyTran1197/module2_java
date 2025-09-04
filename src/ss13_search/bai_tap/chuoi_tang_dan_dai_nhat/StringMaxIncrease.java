package ss13_search.bai_tap.chuoi_tang_dan_dai_nhat;

import java.util.Scanner;

public class StringMaxIncrease {
    static String findStringMax(String str) {
        int n = str.length();

        int[] saveStr = new int[n];
        int[] reverse = new int[n];

        for (int i = 0; i < n; i++) {
            saveStr[i] = 1;
            reverse[i] = -1;
        }
        int max = 1;
        int end = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < str.charAt(i) && saveStr[j] + 1 > saveStr[i]) {
                    saveStr[i] = saveStr[j] + 1;
                    reverse[i] = j;
                }
            }
            if (saveStr[i] > max) {
                max = saveStr[i];
                end = i;
            }
        }
        char[] listChar = new char[max];
        int t = max - 1;
        int i = end;
        while (i>=0){
            listChar[t] = str.charAt(i);
            i = reverse[i];
            t--;
        }
        String result = "";
        for (int j = 0; j < max; j++) {
            result += listChar[j];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string: ");
        String str = scanner.nextLine();
        System.out.println(findStringMax(str));
    }
}
