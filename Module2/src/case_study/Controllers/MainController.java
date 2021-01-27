package case_study.Controllers;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Exit");
            chooseMenu = sc.nextInt();

            switch (chooseMenu){
                case 1:
                    addNewServices();
                    break;
                case 2:

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
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            chooseServices = sc.nextInt();

            switch (chooseServices){
                case 1:
                    System.out.println("Nhập id: ");
                    int idVilla = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên dịch vụ: ");
                    String tenDichVuVilla  = sc.nextLine();
                    System.out.println("Nhập diện tích sử dụng: ");
                    int dienTichSuDungVilla  = sc.nextInt();
                    System.out.println("Nhập chi phí thuê: ");
                    double chiPhiThueVilla  = sc.nextInt();
                    System.out.println("Nhập so lượng người tối đa: ");
                    int soLuongNguoiVilla  = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập kiểu thuê: ");
                    String kieuThueVilla  = sc.nextLine();
                    System.out.println("Nhập tiêu chuẩn phòng: ");
                    String tieuChuanPhongVilla  = sc.nextLine();
                    System.out.println("Nhập mô tả tiện nghi khác: ");
                    String tienNghiKhacVilla  = sc.nextLine();
                    System.out.println("Nhập diện tích hồ bơi: ");
                    int dienTichHoBoiVilla  = sc.nextInt();
                    System.out.println("Nhập số tầng: ");
                    int soTangVilla  = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Nhập id: ");
                    int idHouse = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên dịch vụ: ");
                    String tenDichVuHouse  = sc.nextLine();
                    System.out.println("Nhập diện tích sử dụng: ");
                    int dienTichSuDungHouse  = sc.nextInt();
                    System.out.println("Nhập chi phí thuê: ");
                    double chiPhiThueHouse  = sc.nextInt();
                    System.out.println("Nhập so lượng người tối đa: ");
                    int soLuongNguoiHouse  = sc.nextInt();
                    System.out.println("Nhập kiểu thuê: ");
                    sc.nextLine();
                    String kieuThueHouse = sc.nextLine();
                    System.out.println("Nhập tiêu chuẩn phòng: ");
                    String tieuChuanPhongHouse  = sc.nextLine();
                    System.out.println("Nhập mô tả tiện nghi khác: ");
                    String tienNghiKhacHouse  = sc.nextLine();
                    System.out.println("Nhập số tầng: ");
                    int soTangHouse = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Nhập id: ");
                    int idRoom = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhập tên dịch vụ: ");
                    String tenDichVuRoom  = sc.nextLine();
                    System.out.println("Nhập diện tích sử dụng: ");
                    int dienTichSuDungRoom   = sc.nextInt();
                    System.out.println("Nhập chi phí thuê: ");
                    double chiPhiThueRoom   = sc.nextInt();
                    System.out.println("Nhập so lượng người tối đa: ");
                    int soLuongNguoiRoom   = sc.nextInt();
                    System.out.println("Nhập kiểu thuê: ");
                    sc.nextLine();
                    String kieuThueRoom  = sc.nextLine();
                    System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
                    String dichVuMienPhiDiKem   = sc.nextLine();
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



    public static void main(String[] args) {
        displayMainMenu();
    }
}
