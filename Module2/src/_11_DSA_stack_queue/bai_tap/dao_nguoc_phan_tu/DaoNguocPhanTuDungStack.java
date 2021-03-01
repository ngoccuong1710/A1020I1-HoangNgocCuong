package _11_DSA_stack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.Arrays;
import java.util.Stack;

public class DaoNguocPhanTuDungStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1, 2, 3, 4, 5};

        for(int i=0; i< arr.length; i++) {
            stack.push(arr[i]);
        }

        int[] reverseArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reverseArray[i] = stack.pop();
        }
        System.out.println("Reversed array is: " + Arrays.toString(reverseArray));
    }
}
