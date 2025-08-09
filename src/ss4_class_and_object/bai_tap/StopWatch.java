package ss4_class_and_object.bai_tap;
import java.util.Scanner;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        this.startTime = System.currentTimeMillis();
    }
    public long getStart(){
        return startTime;
    }
    public long getEnd(){
        return endTime;
    }
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    public void stop(){
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return getEnd() - getStart();
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter size: ");
        int numbers = Integer.parseInt(scanner.nextLine());
        int[] array = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            System.out.print("enter element "+i+": ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        selectionSort(array);
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime()+" ms");
    }
}
