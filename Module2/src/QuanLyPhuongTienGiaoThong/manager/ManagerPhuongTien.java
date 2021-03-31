package QuanLyPhuongTienGiaoThong.manager;

import QuanLyPhuongTienGiaoThong.common.WriteAndReadFile;
import QuanLyPhuongTienGiaoThong.controller.MainController;
import QuanLyPhuongTienGiaoThong.model.OTo;
import QuanLyPhuongTienGiaoThong.model.XeMay;
import QuanLyPhuongTienGiaoThong.model.XeTai;
import QuanLySanPham.common.FuncWriteAndRead;
import QuanLySanPham.model.Product;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerPhuongTien {
    private static final String FILE_NAME_XETAI = "src/QuanLyPhuongTienGiaoThong/data/xeTai.csv";
    private static final String FILE_NAME_OTO = "src/QuanLyPhuongTienGiaoThong/data/oto.csv";
    private static final String FILE_NAME_XEMAY = "src/QuanLyPhuongTienGiaoThong/data/xeMay.csv";

    public static void addXeTai(){
        List<XeTai> xeTaiList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        String bienKiemSoat;
        do {
            System.out.println("Nhập biển kiểm soát");
            bienKiemSoat = sc.nextLine();
            if (bienKiemSoat.matches("(\\d){2}(C)\\-(\\d){3}\\.(\\d){2}")){
                check = true;
            }
            else System.out.println("Dữ liệu ko hợp lệ, mời nhập lại");
        }while (!check);
        check = false;

        System.out.println("Nhập hảng sản xuất");
        String hangSanXuat = sc.nextLine();

        System.out.println("Nhập năm sản xuất");
        int namSanXuat = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chủ sở hữu");
        String chuSoHuu = sc.nextLine();
        System.out.println("Nhập trong tải");
        int trongTai = Integer.parseInt(sc.nextLine());

        XeTai xeTai = new XeTai(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, trongTai);
        xeTaiList.add(xeTai);
        WriteAndReadFile.writeXeTai(xeTaiList, true);
//        String line = null;
//        for (XeTai xeTaiLine: xeTaiList){
//            line = xeTaiLine.getBienKiemSoat() + ", " + xeTaiLine.getTenHang() + ", " + xeTaiLine.getNamSanXuat()
//                    + ", " + xeTaiLine.getChuSoHuu() + ", " + xeTaiLine.getTrongTai();
//        }
//
//        WriteAndReadFile.writeFile(FILE_NAME_XETAI, line);
    }

    public static void addOTo(){
        List<OTo> oToList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        String bienKiemSoat;
        do {
            System.out.println("Nhập biển kiểm soát");
            bienKiemSoat = sc.nextLine();
            if (bienKiemSoat.matches("(\\d){2}(A|B)\\-(\\d){3}\\.(\\d){2}")){
                check = true;
            }
            else System.out.println("Dữ liệu ko hợp lệ, mời nhập lại");
        }while (!check);
        check = false;

        System.out.println("Nhập hảng sản xuất");
        String hangSanXuat = sc.nextLine();
        System.out.println("Nhập năm sản xuất");
        int namSanXuat = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chủ sở hữu");
        String chuSoHuu = sc.nextLine();
        System.out.println("Nhập số chỗ ngồi");
        int soChoNgoi = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu xe");
        String kieiXe = sc.nextLine();

        OTo oTo = new OTo(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, soChoNgoi, kieiXe);
        oToList.add(oTo);

        String line = null;
        for (OTo oToLine: oToList){
            line = oToLine.getBienKiemSoat() + ", " + oToLine.getTenHang() + ", " + oToLine.getNamSanXuat()
                    + ", " + oToLine.getChuSoHuu() + ", " + oToLine.getSoChoNgoi() + ", " + oToLine.getKieuXe();
        }

        WriteAndReadFile.writeFile(FILE_NAME_OTO, line);
    }

    public static void addXeMay(){
        List<XeMay> xeMayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        String bienKiemSoat;
        do {
            System.out.println("Nhập biển kiểm soát");
            bienKiemSoat = sc.nextLine();
            if (bienKiemSoat.matches("[\\d]{2}\\-[A-Z]([\\d]{1}|[A-Z])\\-[\\d]{3}\\.[\\d]{2}")){
                check = true;
            }
            else System.out.println("Dữ liệu ko hợp lệ, mời nhập lại");
        }while (!check);
        check = false;

        System.out.println("Nhập hảng sản xuất");
        String hangSanXuat = sc.nextLine();
        System.out.println("Nhập năm sản xuất");
        int namSanXuat = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chủ sở hữu");
        String chuSoHuu = sc.nextLine();
        System.out.println("Nhập công suất");
        int congSuat = Integer.parseInt(sc.nextLine());

        XeMay xeMay = new XeMay(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, congSuat);
        xeMayList.add(xeMay);
        String line = null;
        for (XeMay xeMayLine: xeMayList){
            line = xeMayLine.getBienKiemSoat() + ", " + xeMayLine.getTenHang() + ", " + xeMayLine.getNamSanXuat()
                    + ", " + xeMayLine.getChuSoHuu() + ", " + xeMayLine.getCongSuat();
        }

        WriteAndReadFile.writeFile(FILE_NAME_XEMAY, line);
    }

    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("1. Hiển thị xe tải");
            System.out.println("2. Hiển thị ô tô");
            System.out.println("3. Hiển thị xe máy");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    List<XeTai> xeTaiList = WriteAndReadFile.readFileXeTai();
                    for (int i = 0; i < xeTaiList.size(); i++){
                        System.out.println((i + 1)+ "-----------" + xeTaiList.get(i) + "\n");
                    }
                    break;
                case 2:
                    List<OTo> oToList = WriteAndReadFile.readFileOTo();
                    for (int i = 0; i < oToList.size(); i++){
                        System.out.println((i + 1)+ "-----------" + oToList.get(i) + "\n");
                    }
                    break;
                case 3:
                    List<XeMay> xeMayList = WriteAndReadFile.readFileXeMay();
                    for (int i = 0; i < xeMayList.size(); i++){
                        System.out.println((i + 1)+ "-----------" + xeMayList.get(i) + "\n");
                    }
                    break;
            }
        }while (chooseMenu != 0);
    }

    public static void deleteMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("1. Xóa xe tải");
            System.out.println("2. Xóa thị ô tô");
            System.out.println("3. Xóa thị xe máy");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    deleteXeTai();
                    break;
                case 2:
                    deleteOto();
                    break;
                case 3:
                   deleteXeMay();
                    break;
            }
        }while (chooseMenu != 0);
    }

    public static void deleteXeTai(){
        Scanner sc = new Scanner(System.in);
        List<XeTai> xeTaiList = WriteAndReadFile.readFileXeTai();
        System.out.println("Nhận biển kiểm soát");
        String bienKSDel = sc.nextLine();

        for (int i = 0; i < xeTaiList.size(); i++){
            XeTai xeTai = xeTaiList.get(0);
            if (xeTai.getBienKiemSoat().contains(bienKSDel)){
                xeTaiList.remove(xeTai);
                WriteAndReadFile.writeXeTai(xeTaiList, false);
            }
        }
    }

    public static void deleteOto(){
        Scanner sc = new Scanner(System.in);
        List<OTo> oToList = WriteAndReadFile.readFileOTo();
        System.out.println("Nhận biển kiểm soát");
        String bienKSDel = sc.nextLine();

        for (int i = 0; i < oToList.size(); i++){
            OTo oTo = oToList.get(0);
            if (oTo.getBienKiemSoat().contains(bienKSDel)){
                oToList.remove(oTo);
                WriteAndReadFile.writeOTo(oToList, false);
            }
        }
    }

    public static void deleteXeMay(){
        Scanner sc = new Scanner(System.in);
        List<XeMay> xeMayList = WriteAndReadFile.readFileXeMay();
        System.out.println("Nhận biển kiểm soát");
        String bienKSDel = sc.nextLine();

        for (int i = 0; i < xeMayList.size(); i++){
            XeMay xeMay = xeMayList.get(0);
            if (xeMay.getBienKiemSoat().contains(bienKSDel)){
                xeMayList.remove(xeMay);
                WriteAndReadFile.writeXeMay(xeMayList, false);
            }
        }
    }
}
