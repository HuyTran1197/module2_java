package ss11_dsa_stack_queue.dao_nguoc_phan_tu_mang_stack;

import java.util.Stack;

public class Reverse {
    public static void reverseInteger(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for (int number : arr){
            stack.push(number);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println("Array integer after reverse");
        for (int number : arr){
            System.out.print(number+" ");
        }
    }

    public static void reverseString(String words){
        String[] mWords = words.split(" ");
        Stack<String> wStack = new Stack<>();
        for (String word : mWords){
            wStack.push(word);
        }
        String outp = "";
        while(!wStack.isEmpty()){
            String mWord = wStack.pop();
            outp = outp + mWord + " ";
        }
        System.out.println("String after reverse '"+outp+'\'');
    }
}
