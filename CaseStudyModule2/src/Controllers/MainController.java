package Controllers;



import Commons.FileUtils;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainController {
    public static List<Villa> listInfoVilla = new ArrayList<>();
    public static List<House> listInfoHouse = new ArrayList<>();
    public static List<Room> listInfoRoom = new ArrayList<>();
    public static List<Customer> listInfoCustomer = new ArrayList<>();
    public static final String FILE_NAME_VILLA = "src/Data/Villa.csv";
    public static final String FILE_NAME_HOUSE = "src/Data/House.csv";
    public static final String FILE_NAME_ROOM = "src/Data/Room.csv";
    public static final String FILE_NAME_CUSTOMER = "src/Data/Customer.csv";

    private static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(sc, listInfoCustomer);
                    break;
                case 4:
                    showInformationCustomer();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }
    
    private static void addNewServices(){
        Scanner sc = new Scanner(System.in);
        int chooseServices;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            chooseServices = Integer.parseInt(sc.nextLine());

            switch (chooseServices){
                case 1:
                    addNewVilla(sc, listInfoVilla);
                    break;
                case 2:
                    addNewHouse(sc, listInfoHouse);
                    break;
                case 3:
                    addNewRoom(sc, listInfoRoom);
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }

    private static void addNewVilla(Scanner sc, List<Villa> listInfoVilla) {
        boolean checkValid = false;

        String regexIdVilla = "^(SVVL)([\\\\w-])([\\d]{4})";
        String idVilla;
        do {
            System.out.println("Nhập id: ");
            idVilla = sc.nextLine();
            if (Pattern.matches(regexIdVilla, idVilla)) {
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
            String firstIndex = tenDichVuVilla.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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
            String firstIndex = kieuThueVilla.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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
            String firstIndex = tieuChuanPhongVilla.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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

        String line = null;
        for (Villa villa: listInfoVilla){
            line = villa.getId() + ", " + villa.getTenDichVu() + ", " + villa.getDienTichSuDung() + ", " +
                    villa.getChiPhiThue() + ", " + villa.getSoLuongNguoi() + ", " + villa.getKieuThue() + ", " +
                    villa.getTieuChuanPhong() + ", " + villa.getMoTaTienNghiKhac() + ", " +
                    villa.getDienTichHoBoi() + ", " + villa.getSoTang();

            FileUtils.writeFile(FILE_NAME_VILLA, line);
        }
    }

    private static void addNewHouse(Scanner sc, List<House> listInfoHouse) {
        boolean checkValid = false;

        String regexIdHouse = "^(SVHO)([\\\\w-])([\\d]{4})";
        String idHouse;
        do {
            System.out.println("Nhập id: ");
            idHouse = sc.nextLine();
            if (Pattern.matches(regexIdHouse, idHouse)){
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, nhập lại.");
            }
        }while (!checkValid);

        String tenDichVuHouse;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuHouse = sc.nextLine();
            String firstIndex = tenDichVuHouse.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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
            String firstIndex = kieuThueHouse.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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
            String firstIndex = tieuChuanPhongHouse.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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

    private static void addNewRoom(Scanner sc, List<Room> listInfoRoom) {
        boolean checkValid = false;

        String regexIdRoom = "^(SVRO)([\\\\w-])([\\d]{4})";
        String idRoom;
        do {
            System.out.println("Nhập id: ");
            idRoom = sc.nextLine();
            if (Pattern.matches(regexIdRoom, idRoom)){
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, nhập lại.");
            }
        }while (!checkValid);


        String tenDichVuRoom;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuRoom = sc.nextLine();
            String firstIndex = tenDichVuRoom.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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
            String firstIndex = kieuThueRoom.substring(0, 1);
            if (firstIndex.matches("^[A-Z]")){
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
            if (dichVuMienPhiDiKem.equals("Massage") || dichVuMienPhiDiKem.equals("Karaoke") || dichVuMienPhiDiKem.equals("Food") ||
                    dichVuMienPhiDiKem.equals("Drink") || dichVuMienPhiDiKem.equals("Car") || dichVuMienPhiDiKem.equals("Tay vịn")){
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

    public static void showServices(){
        Scanner sc = new Scanner(System.in);

        int chooseServices;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Show all Villa");
            System.out.println("2. Show all House");
            System.out.println("3. Show all Room");
            System.out.println("4. Show all Name Villa Not Duplicate");
            System.out.println("5. Show all Name House Not Duplicate");
            System.out.println("6. Show all Name Room Not Duplicate");
            System.out.println("7. Back to menu");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            chooseServices = sc.nextInt();

            switch (chooseServices){
                case 1:
                    FileUtils.readFileVilla(FILE_NAME_VILLA);
                    break;
                case 2:
                    FileUtils.readFileHouse(FILE_NAME_HOUSE);
                    break;
                case 3:
                    FileUtils.readFileRoom(FILE_NAME_ROOM);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }

    private static void addNewCustomer(Scanner sc, List<Customer> listInfoCustomer){
        System.out.println("Nhập họ tên customer: ");
        String tenCustomer = sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String ngaySinhCustomer = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        String gioiTinhCustomer = sc.nextLine();
        System.out.println("Nhập số CMND: ");
        String cMNDCustomer = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String soDTCustomer = sc.nextLine();
        System.out.println("Nhập email: ");
        String emailCustomer = sc.nextLine();
        System.out.println("Nhập loại khách: ");
        String loaiCustomer = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String diaChiCustomer = sc.nextLine();
        System.out.println("Nhập id dịch vụ: ");
        String idDichVu = sc.nextLine();
        System.out.println("Nhập tên dịch vụ: ");
        String tenDichVu = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        int dienTichSuDung = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chi phí thuê: ");
        int chiPhiThue = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số lượng người: ");
        int soLuongNguoi = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String kieuThue = sc.nextLine();
        Customer inforCustomer = new Customer(tenCustomer, ngaySinhCustomer, gioiTinhCustomer, cMNDCustomer, soDTCustomer,
                emailCustomer, loaiCustomer, diaChiCustomer, idDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        listInfoCustomer.add(inforCustomer);

        String line = null;
        for (Customer customer: listInfoCustomer){
            line = customer.getTenCustomer() + ", " + customer.getNgaySinh() + ", " + customer.getGioiTinh() + ", " +
                    customer.getCmnd() + ", " + customer.getSoDT() + ", " + customer.getEmail() + ", " +
                    customer.getLoaiKhach() + ", " + customer.getDiaChi();

            FileUtils.writeFile(FILE_NAME_CUSTOMER, line);
        }
    }

    private static void showInformationCustomer(){
        FileUtils.readFileCustomer(FILE_NAME_CUSTOMER);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
