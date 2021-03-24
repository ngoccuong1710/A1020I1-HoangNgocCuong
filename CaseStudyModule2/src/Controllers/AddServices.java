package Controllers;

import Commons.FileUtils;
import Models.House;
import Models.Room;
import Models.Villa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddServices {
    private static final String FILE_NAME_VILLA = "src/Data/Villa.csv";
    private static final String FILE_NAME_HOUSE = "src/Data/House.csv";
    private static final String FILE_NAME_ROOM = "src/Data/Room.csv";

    public static void addNewVilla() {
        List<Villa> listInfoVilla = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;

        String idVilla;
        do {
            System.out.println("Nhập id: ");
            idVilla = sc.nextLine();
            if (idVilla.matches("^(SVVL)([\\\\w-])([\\d]{4})")) {
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, mời nhập lại.");
            }
        } while (!checkValid);
        checkValid = false;

        String tenDichVuVilla;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuVilla = sc.nextLine();
            if (tenDichVuVilla.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int dienTichSuDungVilla;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            dienTichSuDungVilla = Integer.parseInt(sc.nextLine());
            if (dienTichSuDungVilla > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid=false;

        int chiPhiThueVilla;
        do {
            System.out.println("Nhập chi phí thuê: ");
            chiPhiThueVilla  = Integer.parseInt(sc.nextLine());
            if (chiPhiThueVilla > 0){
                checkValid = true;
            }
            else {
                System.out.println("Chi phí thuê phải là số dương, mới nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soLuongNguoiVilla;
        do {
            System.out.println("Nhập so lượng người tối đa: ");
            soLuongNguoiVilla  = Integer.parseInt(sc.nextLine());
            if (soLuongNguoiVilla > 0 && soLuongNguoiVilla < 20){
                checkValid = true;
            }
            else {
                System.out.println("Số lượng người ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String kieuThueVilla;
        do {
            System.out.println("Nhập kiểu thuê: ");
            kieuThueVilla  = sc.nextLine();
            if (kieuThueVilla.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String tieuChuanPhongVilla;
        do {
            System.out.println("Nhập tiêu chuẩn phòng: ");
            tieuChuanPhongVilla  = sc.nextLine();
            if (tieuChuanPhongVilla.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        System.out.println("Nhập mô tả tiện nghi khác: ");
        String tienNghiKhacVilla  = sc.nextLine();

        int dienTichHoBoiVilla;
        do {
            System.out.println("Nhập diện tích hồ bơi: ");
            dienTichHoBoiVilla  = Integer.parseInt(sc.nextLine());
            if (dienTichHoBoiVilla > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích hồ bơi phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soTangVilla;
        do {
            System.out.println("Nhập số tầng: ");
            soTangVilla  = Integer.parseInt(sc.nextLine());
            if (soTangVilla > 0){
                checkValid = true;
            }
            else {
                System.out.println("Số tầng phải là số nguyên dương, mời nhập lại");
            }
        }while (!checkValid);

        Villa inforVilla = new Villa(idVilla, tenDichVuVilla, dienTichSuDungVilla, chiPhiThueVilla, soLuongNguoiVilla,
                kieuThueVilla, tieuChuanPhongVilla, tienNghiKhacVilla, dienTichHoBoiVilla, soTangVilla);
        listInfoVilla.add(inforVilla);

        String line;
        for (Villa villa: listInfoVilla){
            line = villa.getId() + ", " + villa.getTenDichVu() + ", " + villa.getDienTichSuDung() + ", " +
                    villa.getChiPhiThue() + ", " + villa.getSoLuongNguoi() + ", " + villa.getKieuThue() + ", " +
                    villa.getTieuChuanPhong() + ", " + villa.getMoTaTienNghiKhac() + ", " +
                    villa.getDienTichHoBoi() + ", " + villa.getSoTang();

            FileUtils.writeFile(FILE_NAME_VILLA, line);
        }
    }

    public static void addNewHouse() {
        List<House> listInfoHouse = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;

        String idHouse;
        do {
            System.out.println("Nhập id: ");
            idHouse = sc.nextLine();
            if (idHouse.matches("^(SVHO)([\\\\w-])([\\d]{4})")){
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, nhập lại.");
            }
        }while (!checkValid);
        checkValid = false;

        String tenDichVuHouse;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuHouse = sc.nextLine();
            if (tenDichVuHouse.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int dienTichSuDungHouse;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            dienTichSuDungHouse = Integer.parseInt(sc.nextLine());
            if (dienTichSuDungHouse > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid=false;

        int chiPhiThueHouse;
        do {
            System.out.println("Nhập chi phí thuê: ");
            chiPhiThueHouse  = Integer.parseInt(sc.nextLine());
            if (chiPhiThueHouse > 0){
                checkValid = true;
            }
            else {
                System.out.println("Chi phí thuê phải là số dương, mới nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soLuongNguoiHouse;
        do {
            System.out.println("Nhập so lượng người tối đa: ");
            soLuongNguoiHouse  = Integer.parseInt(sc.nextLine());
            if (soLuongNguoiHouse > 0 && soLuongNguoiHouse < 20){
                checkValid = true;
            }
            else {
                System.out.println("Số lượng người ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String kieuThueHouse;
        do {
            System.out.println("Nhập kiểu thuê: ");
            kieuThueHouse  = sc.nextLine();
            if (kieuThueHouse.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String tieuChuanPhongHouse;
        do {
            System.out.println("Nhập tiêu chuẩn phòng: ");
            tieuChuanPhongHouse  = sc.nextLine();
            if (tieuChuanPhongHouse.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        System.out.println("Nhập mô tả tiện nghi khác: ");
        String tienNghiKhacHouse  = sc.nextLine();

        int soTangHouse;
        do {
            System.out.println("Nhập số tầng: ");
            soTangHouse  = Integer.parseInt(sc.nextLine());
            if (soTangHouse > 0){
                checkValid = true;
            }
            else {
                System.out.println("Số tầng phải là số nguyên dương, mời nhập lại");
            }
        }while (!checkValid);

        House inforHouse = new House(idHouse, tenDichVuHouse, dienTichSuDungHouse, chiPhiThueHouse, soLuongNguoiHouse,
                kieuThueHouse, tieuChuanPhongHouse, tienNghiKhacHouse, soTangHouse);
        listInfoHouse.add(inforHouse);

        String line = null;
        for (House house: listInfoHouse){
            line = house.getId() + ", " + house.getTenDichVu() + ", " + house.getDienTichSuDung() + ", " +
                    house.getChiPhiThue() + ", " + house.getSoLuongNguoi() + ", " + house.getKieuThue() + ", " +
                    house.getMoTaTienNghiKhac() + ", " + house.getTieuChuanPhong() + ", " + house.getSoTang();

            FileUtils.writeFile(FILE_NAME_HOUSE, line);
        }
    }

    public static void addNewRoom() {
        List<Room> listInfoRoom = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;

        String idRoom;
        do {
            System.out.println("Nhập id: ");
            idRoom = sc.nextLine();
            if (idRoom.matches("^(SVRO)([\\\\w-])([\\d]{4})")){
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, nhập lại.");
            }
        }while (!checkValid);
        checkValid = false;

        String tenDichVuRoom;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuRoom = sc.nextLine();
            if (tenDichVuRoom.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int dienTichSuDungRoom;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            dienTichSuDungRoom = Integer.parseInt(sc.nextLine());
            if (dienTichSuDungRoom > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid=false;

        int chiPhiThueRoom;
        do {
            System.out.println("Nhập chi phí thuê: ");
            chiPhiThueRoom  = Integer.parseInt(sc.nextLine());
            if (chiPhiThueRoom > 0){
                checkValid = true;
            }
            else {
                System.out.println("Chi phí thuê phải là số dương, mới nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soLuongNguoiRoom;
        do {
            System.out.println("Nhập so lượng người tối đa: ");
            soLuongNguoiRoom  = Integer.parseInt(sc.nextLine());
            if (soLuongNguoiRoom > 0 && soLuongNguoiRoom < 20){
                checkValid = true;
            }
            else {
                System.out.println("Số lượng người ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String kieuThueRoom;
        do {
            System.out.println("Nhập kiểu thuê: ");
            kieuThueRoom  = sc.nextLine();
            if (kieuThueRoom.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String dichVuMienPhiDiKem;
        do {
            System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
            dichVuMienPhiDiKem   = sc.nextLine();
            if (dichVuMienPhiDiKem.matches("^(massage|karaoke|food|drink|car)$")){
                checkValid = true;
            }
            else {
                System.out.println("ko có dịch vụ này");
            }
        }while (!checkValid);

        Room inforRoom = new Room(idRoom, tenDichVuRoom, dienTichSuDungRoom, chiPhiThueRoom, soLuongNguoiRoom,
                kieuThueRoom, dichVuMienPhiDiKem);
        listInfoRoom.add(inforRoom);

        String line = null;
        for (Room room: listInfoRoom){
            line = room.getId() + ", " + room.getTenDichVu() + ", " + room.getDienTichSuDung() + ", " +
                    room.getChiPhiThue() + ", " + room.getSoLuongNguoi() + ", " + room.getKieuThue() + ", " +
                    room.getDichVuMienPhiDiKem();

            FileUtils.writeFile(FILE_NAME_ROOM, line);
        }
    }
}
