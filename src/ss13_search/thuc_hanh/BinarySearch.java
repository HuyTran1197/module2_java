package ss13_search.thuc_hanh;

public class BinarySearch {
    static void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static int binarySearch(int[] list, int v) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (v == list[mid]) {
                return mid;
            } else if (v < list[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {5,2,6,8,0,14};
        int[] arr2 = {5,3,7,8,0,29};
        int[] arr3 = {5,1,6,8,20,14};
        sort(arr1);
        sort(arr2);
        sort(arr3);
        System.out.println(binarySearch(arr1,5));
        System.out.println(binarySearch(arr2,29));
        System.out.println(binarySearch(arr3,20));
    }
}

