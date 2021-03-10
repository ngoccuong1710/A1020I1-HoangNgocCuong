package Commons;

import Models.Villa;

import java.io.*;
import java.util.*;

public class FileUtils {
    public static void writeFile(String pathFile, String line){
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileVilla(String pathFile){
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineVilla = null;

            while ((lineVilla = bufferedReader.readLine()) != null){
                villaInfor((parseCsvLine(lineVilla)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileHouse(String pathFile){
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineHouse = null;

            while ((lineHouse = bufferedReader.readLine()) != null){
                houseInfor((parseCsvLine(lineHouse)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileRoom(String pathFile){
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineRoom = null;

            while ((lineRoom = bufferedReader.readLine()) != null){
                roomInfor((parseCsvLine(lineRoom)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileCustomer(String pathFile){
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineCustomer = null;

            while ((lineCustomer = bufferedReader.readLine()) != null){
                customerInfor((parseCsvLine(lineCustomer)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> parseCsvLine(String csvLine){
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(", ");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void villaInfor (List<String> villa){
        System.out.println(
                "\n1. Id: " + villa.get(0) +
                "\n2. Tên dịch vụ: " + villa.get(1) +
                "\n3. Diện tích sử dụng " + villa.get(2) +
                "\n4. Chi phí thuê: " + villa.get(3) +
                "\n5. Số lượng người tối đa: " + villa.get(4) +
                "\n6. Kiểu thuê: " + villa.get(5) +
                "\n7. Tiêu chuẩn phòng: " + villa.get(6) +
                "\n8. Mô tả tiện nghi khác: " + villa.get(7) +
                "\n9. Diện tích hồ bơi " + villa.get(8) +
                "\n10. Số tầng: " + villa.get(9));
    }

    private static void houseInfor (List<String> house){
        System.out.println(
                "\n1. Id: " + house.get(0) +
                "\n2. Tên dịch vụ: " + house.get(1) +
                "\n3. Diện tích sử dụng " + house.get(2) +
                "\n4. Chi phí thuê: " + house.get(3) +
                "\n5. Số lượng người tối đa: " + house.get(4) +
                "\n6. Kiểu thuê: " + house.get(5) +
                "\n7. Tiêu chuẩn phòng: " + house.get(6) +
                "\n8. Mô tả tiện nghi khác: " + house.get(7) +
                "\n9. Số tầng: " + house.get(8));
    }

    private static void roomInfor (List<String> room){
        System.out.println(
                "\n1. Id: " + room.get(0) +
                "\n2. Tên dịch vụ: " + room.get(1) +
                "\n3. Diện tích sử dụng " + room.get(2) +
                "\n4. Chi phí thuê: " + room.get(3) +
                "\n5. Số lượng người tối đa: " + room.get(4) +
                "\n6. Kiểu thuê: " + room.get(5) +
                "\n7. Dịch vụ miễn phí đi kèm: " + room.get(6));
    }

    private static void customerInfor (List<String> customer){
        System.out.println(
                "\n1. Họ tên Customer: " + customer.get(0) +
                "\n2. Ngày sinh: " + customer.get(1) +
                "\n3. Giới tính: " + customer.get(2) +
                "\n4. Số CMND: " + customer.get(3) +
                "\n5. Số điện thoại: " + customer.get(4) +
                "\n6. Email: " + customer.get(5) +
                "\n7. loại khách: " + customer.get(6) +
                "\n8. Địa chỉ: " + customer.get(7));
    }
}

