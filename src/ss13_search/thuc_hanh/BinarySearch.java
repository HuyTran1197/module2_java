package ss13_search.thuc_hanh;

public class BinarySearch {
    public static int[] list = {2, 5, 7, 12, 15, 55, 63, 90};

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
        System.out.println(binarySearch(list, 20));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 90));
        System.out.println(binarySearch(list, 55));
    }
}

