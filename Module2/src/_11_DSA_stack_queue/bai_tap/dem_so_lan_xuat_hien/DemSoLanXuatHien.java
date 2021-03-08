package _11_DSA_stack_queue.bai_tap.dem_so_lan_xuat_hien;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DemSoLanXuatHien {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str = sc.nextLine();
        String [] arr = str.trim().split("");

        Map<String, Integer> map = new HashMap<String,Integer>();
        for(String x: arr){
            if(map.containsKey(x)){
                map.put(x, map.get(x)+1);
            }else{
                map.put(x, 1);
            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println("Từ " + entry.getKey() + " xuất hiện " + entry.getValue() + " lần.");
        }
    }

}
