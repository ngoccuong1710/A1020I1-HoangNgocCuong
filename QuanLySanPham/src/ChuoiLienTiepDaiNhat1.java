import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class ChuoiLienTiepDaiNhat1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) { 		// single loop
            if (list.size()==0||string.charAt(i)> list.getLast()){
                list.add(string.charAt(i));
            }else {
                if (list.size() > max.size()) { // Simple statement
                    max.clear();
                    max.addAll(list);
                    i--;
                }
                list.clear();
            }

        }
        if (list.size()>max.size()){
            max.clear();
            max.addAll(list);
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch: max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();
    }

}
