package ss15_exception.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.creatRandom();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nenter a value of index: ");
        int n = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("value of element has index "+n+" is "+arr[n]);
        } catch (IndexOutOfBoundsException e){
            System.out.println("index out of bounds, fail !");
        }
    }

    public Integer[] creatRandom(){
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("element of array list: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+" ");
        }
        return arr;
    }
}
