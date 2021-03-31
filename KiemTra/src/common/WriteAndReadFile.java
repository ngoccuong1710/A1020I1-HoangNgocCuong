package common;

import model.BenhAnThuong;
import model.BenhAnVip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    private static final String FILE_BENHAN = "src/data/medical_records.csv";

    public static void writeBenhNhanThuong(List<BenhAnThuong> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_BENHAN, selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (BenhAnThuong benhAnThuong: list) {
                bufferedWriter.write(benhAnThuong.getInfor());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeBenhNhanVip(List<BenhAnVip> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_BENHAN, selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (BenhAnVip benhAnVip: list) {
                bufferedWriter.write(benhAnVip.getInfor());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<BenhAnThuong> readFileBenhAn() {
        List<BenhAnThuong> benhAnThuongList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/data/medical_records.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineBenhAn;
            String[] readLineBenhAn;
            BenhAnThuong benhAnThuong = null;
            while ((lineBenhAn = bufferedReader.readLine()) != null) {
                readLineBenhAn = lineBenhAn.split(", ");
                benhAnThuong = new BenhAnThuong();
                benhAnThuong.setIdBenhAn(Integer.parseInt(readLineBenhAn[0]));
                benhAnThuong.setMaBenhAn(readLineBenhAn[1]);
                benhAnThuong.setMaBenhNhan(readLineBenhAn[2]);
                benhAnThuong.setTenBenhNhan(readLineBenhAn[3]);
                benhAnThuong.setNgayNhapVien(readLineBenhAn[4]);
                benhAnThuong.setNgayRaVien(readLineBenhAn[5]);
                benhAnThuong.setLyDoNhapVien(readLineBenhAn[6]);
                benhAnThuongList.add(benhAnThuong);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return benhAnThuongList;
    }
}
