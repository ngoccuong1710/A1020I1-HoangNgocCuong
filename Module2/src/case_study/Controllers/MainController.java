package case_study.Controllers;
import case_study.Commons.FileUtils;
import case_study.Models.Customer;
import case_study.Models.House;
import case_study.Models.Room;
import case_study.Models.Villa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainController {
    public static List<Villa> listInfoVilla = new ArrayList<>();
    public static List<House> listInfoHouse = new ArrayList<>();
    public static List<Room> listInfoRoom = new ArrayList<>();
    public static List<Customer> listInfoCustomer = new ArrayList<>();
    public static final String FILE_NAME_VILLA = "src/case_study/Data/Villa.csv";
    public static final String FILE_NAME_HOUSE = "src/case_study/Data/House.csv";
    public static final String FILE_NAME_ROOM = "src/case_study/Data/Room.csv";

    public static void displayMainMenu(){
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

                case 4:

                case 5:

                case 6:

                case 7:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }
    
    public static void addNewServices(){
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
        System.out.println("Nhập id: ");
        String idVilla = sc.nextLine();
        System.out.println("Nhập tên dịch vụ: ");
        String tenDichVuVilla  = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        int dienTichSuDungVilla  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chi phí thuê: ");
        int chiPhiThueVilla  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập so lượng người tối đa: ");
        int soLuongNguoiVilla  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String kieuThueVilla  = sc.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String tieuChuanPhongVilla  = sc.nextLine();
        System.out.println("Nhập mô tả tiện nghi khác: ");
        String tienNghiKhacVilla  = sc.nextLine();
        System.out.println("Nhập diện tích hồ bơi: ");
        int dienTichHoBoiVilla  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số tầng: ");
        int soTangVilla  = Integer.parseInt(sc.nextLine());
        Villa infoVilla = new Villa(idVilla, tenDichVuVilla, dienTichSuDungVilla, chiPhiThueVilla, soLuongNguoiVilla,
                kieuThueVilla, tieuChuanPhongVilla, tienNghiKhacVilla, dienTichHoBoiVilla, soTangVilla);
        listInfoVilla.add(infoVilla);

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
        System.out.println("Nhập id: ");
        String idHouse = sc.nextLine();
        System.out.println("Nhập tên dịch vụ: ");
        String tenDichVuHouse  = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        int dienTichSuDungHouse  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chi phí thuê: ");
        int chiPhiThueHouse  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập so lượng người tối đa: ");
        int soLuongNguoiHouse  = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String kieuThueHouse = sc.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String tieuChuanPhongHouse  = sc.nextLine();
        System.out.println("Nhập mô tả tiện nghi khác: ");
        String tienNghiKhacHouse  = sc.nextLine();
        System.out.println("Nhập số tầng: ");
        int soTangHouse = Integer.parseInt(sc.nextLine());
        House infoHouse = new House(idHouse, tenDichVuHouse, dienTichSuDungHouse, chiPhiThueHouse, soLuongNguoiHouse,
                kieuThueHouse, tieuChuanPhongHouse, tienNghiKhacHouse, soTangHouse);
        listInfoHouse.add(infoHouse);
        
        String line = null;
        for (House house: listInfoHouse){
            line = house.getId() + ", " + house.getTenDichVu() + ", " + house.getDienTichSuDung() + ", " +
                    house.getChiPhiThue() + ", " + house.getSoLuongNguoi() + ", " + house.getKieuThue() + ", " +
                    house.getMoTaTienNghiKhac() + ", " + house.getTieuChuanPhong() + ", " + house.getSoTang();

            FileUtils.writeFile(FILE_NAME_HOUSE, line);
        }
    }

    private static void addNewRoom(Scanner sc, List<Room> listInfoRoom) {
        System.out.println("Nhập id: ");
        String idRoom = sc.nextLine();
        System.out.println("Nhập tên dịch vụ: ");
        String tenDichVuRoom = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        int dienTichSuDungRoom = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chi phí thuê: ");
        int chiPhiThueRoom = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập so lượng người tối đa: ");
        int soLuongNguoiRoom = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String kieuThueRoom  = sc.nextLine();
        System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
        String dichVuMienPhiDiKem   = sc.nextLine();
        Room infoRoom = new Room(idRoom, tenDichVuRoom, dienTichSuDungRoom, chiPhiThueRoom, soLuongNguoiRoom,
                kieuThueRoom, dichVuMienPhiDiKem);
        listInfoRoom.add(infoRoom);

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
        Customer customer = new Customer(tenCustomer, ngaySinhCustomer, gioiTinhCustomer, cMNDCustomer, soDTCustomer,
                emailCustomer, loaiCustomer, diaChiCustomer);
        listInfoCustomer.add(customer);
    }


    public static void main(String[] args) {
        displayMainMenu();
    }
}
