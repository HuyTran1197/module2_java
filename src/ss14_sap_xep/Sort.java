package ss14_sap_xep;

public class Sort {
    public static int[] insertionSort(int[] arr){
        int pos, x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos>0 && x < arr[pos-1]){
                arr[pos] = arr[pos-1];
                pos--;
            }
            arr[pos] = x;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] list = {3,5,2,7,9,8};
        int[] newList = insertionSort(list);
        for (int num : newList){
            System.out.print(num+" ");
        }
    }
}
