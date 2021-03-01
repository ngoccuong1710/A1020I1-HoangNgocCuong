package _11_DSA_stack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.Stack;

public class DaoNguocChuoiDungStack {
    public static String reverse(String str) {
        Stack<Character> wStack = new Stack<>();
        char[] mWork = str.toCharArray();

        for (int i = 0; i < str.length(); i++)
            wStack.push(mWork[i]);

        int index = 0;

        while (!wStack.isEmpty())
        {
            mWork[index++] = wStack.pop();
        }

        return String.copyValueOf(mWork);
    }

    public static void main (String[] args) {
        String str = "a b c d e f";

        str = reverse(str);

        System.out.println("Reversed string is: " + str);
    }
}
