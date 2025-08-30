package ss11_dsa_stack_queue.chuoi_palindrome;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void checkPalindrome(int[] palindrome){
        Queue<Integer> palQueue = new LinkedList<>();
        Stack<Integer> palStack = new Stack<>();

        for (int n : palindrome){
            palQueue.add(n);
            palStack.push(n);
        }

        boolean checkArr = true;
        while (!palQueue.isEmpty()){
            if (!palQueue.poll().equals(palStack.pop())){
                checkArr = false;
                break;
            }
        }
        if (checkArr){
            System.out.println("Array is a Palindrome");
        } else {
            System.out.println("Array isn't a Palindrome");
        }
    }
}
