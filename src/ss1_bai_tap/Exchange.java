package ss1_bai_tap;

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
        System.out.println("quy đổi " +this.usd+ "usd sang vnd = "+getUsd());
    }
}
