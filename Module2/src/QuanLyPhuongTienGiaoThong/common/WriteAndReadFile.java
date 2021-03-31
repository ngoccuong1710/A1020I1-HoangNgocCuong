package QuanLyPhuongTienGiaoThong.common;

import QuanLyPhuongTienGiaoThong.model.OTo;
import QuanLyPhuongTienGiaoThong.model.XeMay;
import QuanLyPhuongTienGiaoThong.model.XeTai;
import QuanLySanPham.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    private static final String FILE_NAME_XETAI = "src/QuanLyPhuongTienGiaoThong/data/xeTai.csv";
    private static final String FILE_NAME_OTO = "src/QuanLyPhuongTienGiaoThong/data/oto.csv";
    private static final String FILE_NAME_XEMAY = "src/QuanLyPhuongTienGiaoThong/data/xeMay.csv";

    public static void writeFile(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(line);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeXeTai(List<XeTai> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_NAME_XETAI,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (XeTai xeTai: list) {
                bufferedWriter.write(xeTai.getInfoXeTai());
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

    public static void writeOTo(List<OTo> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_NAME_OTO,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (OTo oTo: list) {
                bufferedWriter.write(oTo.getInfoOTo());
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

    public static void writeXeMay(List<XeMay> list, boolean selection){
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_NAME_XEMAY,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (XeMay xeMay: list) {
                bufferedWriter.write(xeMay.getInfoXeMay());
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

    public static List<XeTai> readFileXeTai() {
        List<XeTai> xeTaiList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/QuanLyPhuongTienGiaoThong/data/xeTai.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineXeTai;
            String[] readLineXeTai;
            XeTai xeTai = null;
            while ((lineXeTai = bufferedReader.readLine()) != null) {
                readLineXeTai = lineXeTai.split(", ");
                xeTai = new XeTai(readLineXeTai[0], readLineXeTai[1], Integer.parseInt(readLineXeTai[2]),
                        readLineXeTai[3], Integer.parseInt(readLineXeTai[4]));
                xeTaiList.add(xeTai);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xeTaiList;
    }

    public static List<OTo> readFileOTo() {
        List<OTo> otoList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/QuanLyPhuongTienGiaoThong/data/oto.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineVilla;
            String[] readLineVilla;
            OTo oTo = null;
            while ((lineVilla = bufferedReader.readLine()) != null) {
                readLineVilla = lineVilla.split(", ");
                oTo = new OTo(readLineVilla[0], readLineVilla[1], Integer.parseInt(readLineVilla[2]),
                        readLineVilla[3], Integer.parseInt(readLineVilla[4]), readLineVilla[5]);
                otoList.add(oTo);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return otoList;
    }

    public static List<XeMay> readFileXeMay() {
        List<XeMay> xeMayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/QuanLyPhuongTienGiaoThong/data/xeMay.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineXeMay;
            String[] readLineXeMay;
            XeMay xeMay = null;
            while ((lineXeMay = bufferedReader.readLine()) != null) {
                readLineXeMay = lineXeMay.split(", ");
                xeMay = new XeMay(readLineXeMay[0], readLineXeMay[1], Integer.parseInt(readLineXeMay[2]),
                        readLineXeMay[3], Integer.parseInt(readLineXeMay[4]));
                xeMayList.add(xeMay);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xeMayList;
    }
}
