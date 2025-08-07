package ss2_loop_and_array_method;
public class PrimeLessThan100 {
    public static boolean isPrime2(int n){
        if (n<2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (isPrime2(i)){
                System.out.println(i);
            }
        }
    }
}
