package ss1_bai_tap;
import java.util.Scanner;
public class Exchange {
    double vnd;
    double usd;
    public Exchange(double vnd, double usd){
        this.vnd = vnd;
        this.usd = usd;
    }

    public double getUsd(){
        return this.usd * this.vnd;
    }
    public void display(){
        System.out.println("quy đổi " +this.usd+ " usd sang vnd = "+getUsd());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tỉ giá vnd");
        double vnd = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số tiền usd cần đổi:");
        double usd = Double.parseDouble(scanner.nextLine());
        Exchange quyDoi = new Exchange(vnd,usd);
        quyDoi.display();
    }
}
