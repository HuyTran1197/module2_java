package ss11_dsa_stack_queue.chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Stack;

public class Exchange {
    public static void exchangeNumber(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n>0){
            int result = n%2;
            n/=2;
            stack.push(result);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
// i=0; result=30%2=0; n/=2=>15;
// i=1; rs=15%2=1; n/=2 => 7;
// i=2; rs=7%2=1; n/=2 => 3;
// i=3; rs=3%2=1; n/=2 => 1;
// i=4; rs=1%2=1; n/=2 => 0;