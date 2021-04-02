package KiemTra.manager;



import KiemTra.common.WriteAndReadFile;
import KiemTra.controller.MainController;
import KiemTra.model.BenhAnThuong;
import KiemTra.model.BenhAnVip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnManager {
    public static void addMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("1. thêm bệnh nhân thường:");
            System.out.println("2. Thêm bệnh nhân vip");
            System.out.println("3. Quay lại menu");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    addBenhNhanThuong();
                    break;
                case 2:
                    addBenhNhanVip();
                    break;
                case 3:
                    MainController.displayMainMenu();
                    break;
            }
        }while (chooseMenu != 0);
    }

    private static void addBenhNhanThuong(){
        List<BenhAnThuong> benhAnThuongList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        System.out.println("Số thứ tự");
        int soThuTu = Integer.parseInt(sc.nextLine());


        String maBenhAn;
        do {
            System.out.println("Mã Bệnh án:");
            maBenhAn = sc.nextLine();
            if (maBenhAn.matches("(BA)\\-(\\d){3}")){
                check = true;
            }
        }while (!check);
        check = false;

        String maBenhNhan;
        do {
            System.out.println("Mã Bệnh Nhân:");
            maBenhNhan = sc.nextLine();
            if (maBenhNhan.matches("(BN)\\-(\\d){3}")){
                check = true;
            }
        }while (!check);
        check = false;

        System.out.println("Tên Bệnh Nhân:");
        String tenBenhNhan = sc.nextLine();


        String ngayNhapVien;
        do {
            System.out.println("Ngày nhập viện:");
            ngayNhapVien = sc.nextLine();
            if (ngayNhapVien.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                check = true;
            }
        }while (!check);
        check = false;

        String ngayRaVien;
        do {
            System.out.println("Ngày ra viện:");
            ngayRaVien = sc.nextLine();
            if (ngayRaVien.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                check = true;
            }
        }while (!check);
        check = false;

        System.out.println("Lý do nhập viện:");
        String lyDoNhapVien = sc.nextLine();
        System.out.println("Phí nằm viện:");
        String phiNamVien = sc.nextLine();

        BenhAnThuong benhAnThuong = new BenhAnThuong(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNamVien);
        benhAnThuongList.add(benhAnThuong);

        WriteAndReadFile.writeBenhNhanThuong(benhAnThuongList, true);
    }

    private static void addBenhNhanVip(){
        List<BenhAnVip> benhAnVipList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        System.out.println("Số thứ tự");
        int soThuTu = Integer.parseInt(sc.nextLine());

        String maBenhAn;
        do {
            System.out.println("Mã Bệnh án:");
            maBenhAn = sc.nextLine();
            if (maBenhAn.matches("(BA)\\-(\\d){3}")){
                check = true;
            }
        }while (!check);
        check = false;

        String maBenhNhan;
        do {
            System.out.println("Mã Bệnh Nhân:");
            maBenhNhan = sc.nextLine();
            if (maBenhNhan.matches("(BN)\\-(\\d){3}")){
                check = true;
            }
        }while (!check);
        check = false;

        System.out.println("Tên Bệnh Nhân:");
        String tenBenhNhan = sc.nextLine();

        String ngayNhapVien;
        do {
            System.out.println("Ngày nhập viện:");
            ngayNhapVien = sc.nextLine();
            if (ngayNhapVien.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                check = true;
            }
        }while (!check);
        check = false;

        String ngayRaVien;
        do {
            System.out.println("Ngày ra viện:");
            ngayRaVien = sc.nextLine();
            if (ngayRaVien.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                check = true;
            }
        }while (!check);
        check = false;

        System.out.println("Lý do nhập viện:");
        String lyDoNhapVien = sc.nextLine();

        String loaiVip;
        do {
            System.out.println("Loại vip:");
            loaiVip = sc.nextLine();
            if (loaiVip.matches("(VIP I|VIP II|VIP III)")){
                check = true;
            }
        }while (!check);
        check = false;

        String thoiHanVip;
        do {
            System.out.println("Thời hạn vip:");
            thoiHanVip = sc.nextLine();
            if (thoiHanVip.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                check = true;
            }
        }while (!check);
        check = false;

        BenhAnVip benhAnVip = new BenhAnVip(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVip, thoiHanVip);
        benhAnVipList.add(benhAnVip);

        WriteAndReadFile.writeBenhNhanVip(benhAnVipList, true);
    }

    public static void deleteBenhNhan(){
        Scanner sc = new Scanner(System.in);
        List<BenhAnThuong> benhAnList = WriteAndReadFile.readFileBenhAn();
        System.out.println("Nhận ma bệnh án cần xóa");
        String maBADel = sc.nextLine();

        for (int i = 0; i < benhAnList.size(); i++){
            BenhAnThuong benhAnThuong = benhAnList.get(1);
            if (benhAnThuong.getMaBenhAn().contains(maBADel)){
                benhAnList.remove(benhAnThuong);
                WriteAndReadFile.writeBenhNhanThuong(benhAnList, false);
            }
        }
    }


    public static void showBanhAn(){
        List<BenhAnThuong> benhAnList = WriteAndReadFile.readFileBenhAn();
        for (int i = 0; i < benhAnList.size(); i++){
            System.out.println((1 + i) + " -----------------" + benhAnList.get(i)+ "\n");
        }
    }
}
