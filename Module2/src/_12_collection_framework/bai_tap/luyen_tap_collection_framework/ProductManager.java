package _12_collection_framework.bai_tap.luyen_tap_collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    public static ArrayList<Product> listProduct = new ArrayList<>();
    public static void themSP(Scanner sc){
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String tenSP = sc.nextLine();
        System.out.println("Nhập giá: ");
        int giaTien = Integer.parseInt(sc.nextLine());

        Product product = new Product(id, tenSP, giaTien);
        listProduct.add(product);
    }

    public static void suaSPTheoId(Scanner sc){
        System.out.println("Nhập id sản phẩm cần sửa:");
        int idSP = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm mới");
        String tenSPMoi = sc.nextLine();
        System.out.println("Nhập giá tiền mới");
        int giaTienMoi = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < listProduct.size(); i++){
            if (listProduct.get(i).getId() == idSP){
                listProduct.get(i).setTenSP(tenSPMoi);
                listProduct.get(i).setGiaTien(giaTienMoi);
            }
        }
    }

    public static void xoaSPTheoId(Scanner sc){
        System.out.println("Nhập id sản phẩm cần xóa:");
        int idSP = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < listProduct.size(); i++){
            if (listProduct.get(i).getId() == idSP){
                listProduct.remove(i);
            }
        }
    }

    public static void hienThiSP(){
        for (Product product : listProduct){
            System.out.println("---");
            System.out.println("Id: " + product.getId());
            System.out.println("Tên sản phẩm: " + product.getTenSP());
            System.out.println("Giá tiền: " + product.getGiaTien());
        }
    }

    public static void timKIemSPTheoTen(Scanner sc){
        System.out.println("Nhập tên sản phẩm cần tìm:");
        String tenSP = sc.nextLine();
        ArrayList<Product> arrayTK = new ArrayList<>();

        for (int i =0; i < listProduct.size(); i++){
            if (listProduct.get(i).getTenSP().equals(tenSP)){
                arrayTK.add(listProduct.get(i));
            }else{
                System.out.println("ko có tên sản phẩm này!");
                break;
            }
        }
        for (Product productTK : arrayTK){
            System.out.println("---");
            System.out.println("Id: " + productTK.getId());
            System.out.println("Tên sản phẩm: " + productTK.getTenSP());
            System.out.println("Giá tiền: " + productTK.getGiaTien());
        }
    }

    public static void sapXepTangTheoGia(){
        Collections.sort(listProduct, new sapXepTang());
    }

    public static void sapXepGiamTheoGia(){
        Collections.sort(listProduct, new sapXepGiam());
    }
}

class sapXepTang implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getGiaTien() - o2.getGiaTien();
    }
}

class sapXepGiam implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getGiaTien() - o1.getGiaTien();
    }
}
