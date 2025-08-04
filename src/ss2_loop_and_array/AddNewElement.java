package ss2_loop_and_array;
import java.util.Arrays;
import java.util.Scanner;

public class AddNewElement {
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
        System.out.println("array before add");
        System.out.println(Arrays.toString(array));
        int addX = 4;
        System.out.print("enter index: ");
        int index_add = Integer.parseInt(scanner.nextLine());
        int[] newArr = new int[array.length+1];
        for (int i = 0; i < array.length ; i++) {
            newArr[i] = array[i];
        }
        if (index_add<0 || index_add > newArr.length) {
            System.out.println("cannot add number to array");
        }
        for (int i = newArr.length-2; i >= index_add; i--) {
            newArr[i+1] = newArr[i];
        }
        newArr[index_add] = addX;
        System.out.println("array after add");
        System.out.println(Arrays.toString(newArr));
    }
}
// 2,3,5,7,8,0
// j=4; a[5]=a[4] => 2,3,5,7,0,8;
// j=3; a[4]=a[3] => 2,3,5,0,7,8;
// j=2; a[3]=a[2] => 2,3,0,5,7,8;
